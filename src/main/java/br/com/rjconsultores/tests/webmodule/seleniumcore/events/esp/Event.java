package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Attribute;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

interface Event {

	/**
	 * M�todo com a fun��o de aguardar a tela ser exibida para aplicar um
	 * determinado evento
	 * 
	 * @param attribute
	 *            Tela que sofre o evento
	 */
	default void waitElementReady(Attribute attribute, long numAttempts) {
		// quantidade de tentativas para a exibi��o do elemento
		if (numAttempts == 0) {
			throw new RuntimeException("Quantidade de tentativas excedida. Elemento n�o dispon�vel");
		}

		if (attribute.getFindBy() == null || attribute.getFindBy().getIdentifyBy() == null
				|| attribute.getFindBy().getValue() == null || attribute.getFindBy().getValue().isEmpty()) {
			throw new RuntimeException(
					"O elemento n�o pode ser encontrado com o valor de identifica��o nulo ou vazio.");
		}

		Collection<WebElement> elements = Selenium.getElements(attribute.getFindBy().getIdentifyBy().getDescription(),
				attribute.getFindBy().getValue());

		if (elements == null || elements.isEmpty()) {
			waitElementReady(attribute, --numAttempts, Selenium.getElements(
					attribute.getFindBy().getIdentifyBy().getDescription(), attribute.getFindBy().getValue()));
			return;
		}

		if (!attribute.mustWait()) {
			return;
		}

		for (WebElement element : elements) {
			switch (attribute.getId()) {
			case "text": {
				if (element.getText().trim().equals(attribute.getValue())) {
					if (!element.isDisplayed()) {
						waitElementReady(attribute, --numAttempts, elements);
					}

					return;
				}
			}
				break;
			case "value": {
				if (element.getAttribute("value").trim().equals(attribute.getValue())) {
					if (!element.isDisplayed()) {
						waitElementReady(attribute, --numAttempts, elements);
					}

					return;
				}
			}
				break;
			case "title": {
				if (element.getAttribute("title").trim().equals(attribute.getValue())) {
					if (!element.isDisplayed()) {
						waitElementReady(attribute, --numAttempts, elements);
					}

					return;
				}
			}
			}
		}

		throw new RuntimeException(
				"N�o foi poss�vel encontrar o elemento " + attribute.getValue() + " pelo attributo " + attribute.getId()
						+ ".Consulta realizada via " + attribute.getFindBy().getIdentifyBy().getDescription() + ": "
						+ attribute.getFindBy().getIdentifyBy().getDescription());
	}

	/**
	 * M�todo com a fun��o de aguardar a tela ser exibida para aplicar um
	 * determinado evento
	 * 
	 * @param attribute
	 *            Tela que sofre o evento
	 */
	default void waitElementReady(Attribute attribute, long attemptNumber, Collection<WebElement> elements) {
		System.out.println(attemptNumber);
		// quantidade de tentativas para a exibi��o do elemento
		if (attemptNumber == 0) {
			throw new RuntimeException("Quantidade de tentativas excedida. Elemento n�o dispon�vel");
		}
		
		if (elements == null || elements.isEmpty()) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException interruptedException) {
				throw new RuntimeException("Quantidade de tentativas excedida. Elemento n�o dispon�vel");
			}
			
			waitElementReady(attribute, --attemptNumber, Selenium.getElements(
					attribute.getFindBy().getIdentifyBy().getDescription(), attribute.getFindBy().getValue()));
			return;
		}

		for (WebElement element : elements) {
			switch (attribute.getId()) {
			case "text": {
				if (element.getText().equals(attribute.getValue())) {
					if (!element.isDisplayed()) {
						waitElementReady(attribute, --attemptNumber, elements);
					}

					return;
				}
			}
				break;
			case "value": {
				if (element.getAttribute("value").equals(attribute.getValue())) {
					if (!element.isDisplayed()) {
						waitElementReady(attribute, --attemptNumber, elements);
					}

					return;
				}
			}
				break;
			case "title": {
				if (element.getAttribute("title").equals(attribute.getValue())) {
					if (!element.isDisplayed()) {
						waitElementReady(attribute, --attemptNumber, elements);
					}

					return;
				}
			}
			}
		}
	}

	public default WebElement getElementValue(Map<AttributeKey, String> attributes) {
		String findBy = attributes.get(AttributeKey.FIND_VIEW_COMPONENT_BY);
		if (findBy == null) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.FIND_BY.");
		}

		String valueFindBy = attributes.get(AttributeKey.VALUE_FIND_VIEW_COMPONENT_BY);
		if (valueFindBy == null) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.VALUE_FIND_BY.");
		}

		/*
		 * String componentType = attributes.get(AttributeKey.COMPONENT_TYPE); if
		 * (componentType == null) { throw new
		 * RuntimeException("Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.COMPONENT_TYPE."
		 * ); }
		 */

		String attributeID = attributes.get(AttributeKey.ATTRIBUTE_ID);
		if (attributeID == null) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.ATTRIBUTE_ID.");
		}

		String attributeValue = attributes.get(AttributeKey.ATTRIBUTE_VALUE);
		if (attributeValue == null) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.ATTRIBUTE_VALUE.");
		}

		for (WebElement element : Selenium.getElements(findBy, valueFindBy)) {
			switch (attributeID) {
			case "text": {
				if (element.getText().equals(attributeValue)) {
					return element;
				}
			}
				break;
			case "value": {
				if (element.getAttribute("value").equals(attributeValue)) {
					return element;
				}
			}
				break;
			case "title": {
				if (element.getAttribute("title").equals(attributeValue)) {
					return element;
				}
			}
			}
		}

		throw new RuntimeException("N�o foi poss�vel encontrar o elemento " + attributeValue + " pelo attributo "
				+ attributeID + ".Consulta realizada via " + findBy + ": " + findBy);
	}

	public default WebElement getParentElement(WebElement childElement) {
		return childElement.findElement(By.xpath(".."));
	}

	public default WebElement getElementBySibling(Map<AttributeKey, String> attributes) {
		String findSiblingBy = attributes.get(AttributeKey.FIND_SIBLING_BY);
		if (findSiblingBy == null || findSiblingBy.isEmpty()) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.FIND_SIBLING_BY.");
		}

		String siblingfindBy = attributes.get(AttributeKey.VALUE_FIND_SIBLING);
		if (siblingfindBy == null || findSiblingBy.isEmpty()) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.VALUE_FIND_SIBLING.");
		}

		String attributeValue = attributes.get(AttributeKey.ATTRIBUTE_VALUE);
		if (attributeValue == null || attributeValue.isEmpty()) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.ATTRIBUTE_VALUE.");
		}

		String findChildBy = attributes.get(AttributeKey.FIND_CHILD_BY);
		if (findChildBy == null || findChildBy.isEmpty()) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.FIND_CHILD_BY.");
		}

		String valueFindChildBy = attributes.get(AttributeKey.VALUE_FIND_CHILD_BY);
		if (valueFindChildBy == null || valueFindChildBy.isEmpty()) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.VALUE_FIND_CHILD_BY.");
		}

		Map<AttributeKey, String> siblingAttributes = new HashMap<>();
		siblingAttributes.put(AttributeKey.FIND_VIEW_COMPONENT_BY, findSiblingBy);
		siblingAttributes.put(AttributeKey.VALUE_FIND_VIEW_COMPONENT_BY, siblingfindBy);
		siblingAttributes.put(AttributeKey.ATTRIBUTE_ID, attributes.get(AttributeKey.SIBLING_ID));
		siblingAttributes.put(AttributeKey.ATTRIBUTE_VALUE, attributes.get(AttributeKey.SIBLING_VALUE));

		WebElement parent = getParentElement(
				getParentElement(getParentElement(this.getElementValue(siblingAttributes))));

		System.out.println(parent.getAttribute("id"));

		// refatorar - tratar com recurs�o at� receber um input, label ...

		for (WebElement child : parent.findElements(By.xpath("./child::*"))) {
			/*
			 * for (WebElement childChild: child.findElements(By.xpath("./child::*"))) { for
			 * (WebElement childChildChild: childChild.findElements(By.xpath("./child::*")))
			 * { childChildChild.getTagName(); if
			 * (childChildChild.getAttribute("class").equals(valueFindChildBy)) {
			 * System.out.println(childChildChild.getTagName());
			 * System.out.println(childChildChild.getText()); return childChildChild; } else
			 * if (childChildChild.getTagName().equals("input")) {
			 * System.out.println(childChildChild.getTagName());
			 * System.out.println(childChildChild.getText()); return childChildChild; } } }
			 */

			if (child.getTagName().equals("input")) {
				return child;
			}
		}

		throw new RuntimeException("N�o foi poss�vel encontrar o elemento " + findChildBy);
	}

	public default Set<Component> getChilds(WebElement parent) {
		Set<Component> components = new HashSet<>();
		Collection<WebElement> childs = parent.findElements(By.xpath("./child::*"));

		for (WebElement element : childs) {

			System.out.println(element.getTagName());
			Component component = new Component(element);
			component.registerChilds(getChilds(component.getReference()));
			components.add(component);
		}

		return components;
	}

	public default WebElement getElement(Map<AttributeKey, String> attributes) {
		String findBy = attributes.get(AttributeKey.FIND_VIEW_COMPONENT_BY);
		if (findBy == null) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.FIND_BY.");
		}

		String valueFindBy = attributes.get(AttributeKey.VALUE_FIND_VIEW_COMPONENT_BY);
		if (valueFindBy == null) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.VALUE_FIND_BY.");
		}

		String findAttributeBy = attributes.get(AttributeKey.FIND_ATTRIBUTE_BY);
		if (findAttributeBy == null || findAttributeBy.isEmpty()) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.FIND_ATTRIBUTE_BY.");
		}

		String attributeID = attributes.get(AttributeKey.ATTRIBUTE_ID);
		if (attributeID == null || attributeID.isEmpty()) {
			throw new RuntimeException(
					"Voc� n�o passou o elemento necess�rio para essa opera��o. Configure o atributo AttributeKey.ATTRIBUTE_ID.");
		}

		Collection<WebElement> elements = Selenium.getElements(findBy, valueFindBy);

		for (WebElement element : elements) {
			if (!findAttributeBy.equals("text")) {
				if (element.getAttribute(findAttributeBy) == null
						|| !element.getAttribute(findAttributeBy).contains(attributeID)) {
					continue;
				}

				return element;
			}

			if (element.getText().trim().equals(attributeID)) {
				return element;
			}

		}

		throw new RuntimeException("N�o foi poss�vel encontrar o elemento com o attribute ID " + attributeID);
	}
}