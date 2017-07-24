package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;

interface Selenium {
	static Collection<WebElement> getElements(String findBy, String value) {
		
		if (findBy.equals(ByClassName.class.getSimpleName())) {
			return SeleniumInstance.DRIVER.findElements(By.className(value));
		}
		
		if (findBy.equals(ByTagName.class.getSimpleName())){
			return SeleniumInstance.DRIVER.findElements(By.tagName(value));
		}
		
		if (findBy.equals(ByName.class.getSimpleName())){
			return SeleniumInstance.DRIVER.findElements(By.name(value));
		}
		
		if (findBy.equals(ByPartialLinkText.class.getSimpleName())){
			return SeleniumInstance.DRIVER.findElements(By.partialLinkText(value));
		}
		
		if (findBy.equals(ByCssSelector.class.getSimpleName())) {
			return SeleniumInstance.DRIVER.findElements(By.cssSelector(value));
		}
		
		if (findBy.equals(ByLinkText.class.getSimpleName())) {
			return SeleniumInstance.DRIVER.findElements(By.linkText(value));
		}
		
		throw new RuntimeException("Não foi possível encontrar o elemento " + value);
	}
	
	/*static WebElement getParentElementFromSibling(Map<AttributeKey, String> attributes) {
		if (!attributes.containsKey(AttributeKey.SIBLING_NAME)) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo SIBLING_NAME");
		}
		
		if (!attributes.containsKey(AttributeKey.FIND_PARENT_BY)) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo FIND_PARENT_BY.");
		}
		
		if (!attributes.containsKey(AttributeKey.PARENT_ELEMENT)) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo PARENT_ELEMENT que deve estar relacionado com o atributo FIND_PARENT_BY.");
		}
		
		String siblingName = attributes.get(AttributeKey.SIBLING_NAME);
		
		Map<AttributeKey, String> attributes
		
		for (WebElement parent : getElements(attributes.get(AttributeKey.PARENT_ELEMENT))) {
			WebElement childElement = getChildElementFromParentWithChildName(parent, siblingName); 
			
			if (childElement == null) {
				continue;
			}
			
			return getParentFromWebElement(parent);
		}
		
		throw new RuntimeException("Não foi possível encontrar o elemento " + siblingName + " a partir de seu parent.");
	}*/
	
	/*static WebElement getChildElementFromParentWithChildName(WebElement parent, String childName) {
		for (WebElement element  : parent.findElements(By.xpath("./child::*"))) {
			if (element.getText().equals(childName)) {
				return element;
			}
		}
		
		return null;
	}*/
	
	/*static List<WebElement> getElementFromWebElement(WebElement element, Map<AttributeKey, String> attributes) {
		if (!attributes.containsKey(AttributeKey.ATTRIBUTE_ID)) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeID com o ID do componente (CLASS_NAME, NAME ...");
		}
		
		String attributeID = attributes.get(AttributeKey.ATTRIBUTE_ID);
		
		By[] byValues = { By.className(attributeID), By.cssSelector(attributeID), By.id(attributeID),
				By.linkText(attributeID), By.name(attributeID), By.partialLinkText(attributeID),
				By.tagName(attributeID) };
		
		for (By by : byValues) {
			List<WebElement> elements = element.findElements(by);

			if (elements == null || elements.isEmpty()) {
				continue;
			}
						
			return elements;
		}
		
		throw new RuntimeException("Não foi possível encontrar o elemento com o ID " + attributeID);
	}*/
	
	/*static void sendKeysFromWebElementWithAttributes(WebElement element, Map<AttributeKey, String> attributes) {
		if (!attributes.containsKey(AttributeKey.ATTRIBUTE_VALUE)) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeValue com o valor para ser inserido no elemento.");
		}
		
		element.sendKeys(attributes.get(AttributeKey.ATTRIBUTE_VALUE));
	}*/
	
	/*static WebElement getParentFromWebElement(WebElement element) {
		return element.findElement(By.xpath(".."));
	}*/
}
