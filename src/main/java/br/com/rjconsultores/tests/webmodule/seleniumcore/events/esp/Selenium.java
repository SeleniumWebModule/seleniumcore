package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeID;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.ComponentType;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.FindBy;

interface Selenium {
	/*
	 * static WebElement getElementByExpressionWithInputValue(String
	 * attributeValue) { String expressionComponent =
	 * "//input[@value='".concat(attributeValue).concat("']");
	 * 
	 * if (expressionComponent.isEmpty()) { throw new
	 * RuntimeException("A expressão informada não é suportada."); }
	 * 
	 * return
	 * SeleniumInstance.DRIVER.findElement(By.xpath(expressionComponent)); }
	 * 
	 * static WebElement getElementByExpressionWithImgTitle(String
	 * attributeValue) { String expressionComponent =
	 * "//img[@title='".concat(attributeValue).concat("']");
	 * 
	 * if (expressionComponent.isEmpty()) { throw new
	 * RuntimeException("A expressão informada não é suportada."); }
	 * 
	 * return
	 * SeleniumInstance.DRIVER.findElement(By.xpath(expressionComponent)); }
	 */

	static Collection<WebElement> getElements(String attributeID) {
		By[] byValues = { By.className(attributeID), By.cssSelector(attributeID), By.id(attributeID),
				By.linkText(attributeID), By.name(attributeID), By.partialLinkText(attributeID),
				By.tagName(attributeID) };

		List<WebElement> elements = null;

		for (By by : byValues) {
			elements = SeleniumInstance.DRIVER.findElements(by);

			if (elements != null && !elements.isEmpty()) {
				break;
			}
		}

		return elements;
	}

	static void findElementAndSendKey(Map<AttributeKey, String> attributes) {
		getElements(attributes.get(AttributeKey.ATTRIBUTE_ID)).forEach(elem -> {
			elem.sendKeys(attributes.get(AttributeKey.ATTRIBUTE_VALUE));
		});
	}

	static String findElementAndGetValue(Map<AttributeKey, String> attributes) {
		for (WebElement element : getElements(attributes.get(AttributeKey.ATTRIBUTE_ID))) {
			return element.getAttribute(attributes.get(AttributeKey.ATTRIBUTE_VALUE)).trim();
		}

		throw new RuntimeException("Não foi possível encontrar o elemento solicitado.");
	}

	static boolean findElementAndValidValue(Map<AttributeKey, String> attributes, String value) {
		return findElementAndGetValue(attributes).equals(value);
	}

	static WebElement getElementByTagName(Map<AttributeKey, String> attributes) {
		String tagName = attributes.get(AttributeKey.COMPONENT_NAME);
		String attributeId = attributes.get(AttributeKey.ATTRIBUTE_ID);
		String attributeValue = attributes.get(AttributeKey.ATTRIBUTE_VALUE);

		Collection<WebElement> elements = getElements(tagName);

		//Nem toda solicitação é de um componente
		if (attributes.containsKey(AttributeKey.COMPONENT_TYPE) && attributes.get(AttributeKey.COMPONENT_TYPE).equals(ComponentType.MENU.name())) {
			return getMenuElement(elements, attributeValue);
		}

		for (WebElement element : elements) {
			if (element.getAttribute(attributeId) != null && element.getAttribute(attributeId).equals(attributeValue)) {
				return element;
			}
		}

		throw new RuntimeException("Não foi possível encontrar o elemento " + attributeValue);
	}

	static WebElement getElement(Map<AttributeKey, String> attributes) {
		String findBy = attributes.get(AttributeKey.FIND_BY);
		String componentName = attributes.get(AttributeKey.COMPONENT_NAME);
		String attributeId = attributes.get(AttributeKey.ATTRIBUTE_ID);
		String attributeValue = attributes.get(AttributeKey.ATTRIBUTE_VALUE);

		if (findBy == null || componentName == null ||  attributeValue == null) {
			throw new RuntimeException("Os atributos findby, componentName e attributeValue não podem ter valor nulo.");
		}

		if (!findBy.equals(FindBy.TAG_NAME.name())) {
			for (WebElement element : getElements(componentName)) {
				String elementValue = attributes.get(AttributeKey.ATTRIBUTE_ID).equals(AttributeID.TEXT.name()) ? element.getText() : element.getAttribute(attributeId);

				if (elementValue != null && elementValue.equals(attributeValue)) {
					return element;
				}
			}
			
			throw new RuntimeException("O elemento " + attributeValue + " não pode ser identificado.");
		} else {
			return getElementByTagName(attributes);
		}
	}

	static WebElement getMenuElement(Collection<WebElement> elements, String attributeValue) {
		for (WebElement element : elements) {

			if (element.getText().trim().equals(attributeValue)) {
				return element;
			}
		}

		throw new RuntimeException("Não foi possível encontrar o elemento " + attributeValue);
	}
}
