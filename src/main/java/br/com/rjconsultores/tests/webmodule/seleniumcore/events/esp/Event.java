package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;

interface Event {
	
	/**
	 * Método com a função de aguardar a tela ser exibida para aplicar um
	 * determinado evento
	 * 
	 * @param attribute
	 *            Tela que sofre o evento
	 */
	default void waitElementReady(Map<AttributeKey, String> attributes, int attemptNumber) {
		// quantidade de tentativas para a exibição do elemento
		if (attemptNumber == 0) {
			throw new RuntimeException("Quantidade de tentativas excedida. Elemento não disponível");
		}
		
		String findBy = attributes.get(AttributeKey.FIND_COMPONENT_BY);
		if (findBy == null || findBy.isEmpty()) {
			throw new RuntimeException(
					"Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.FIND_COMPONENT_BY.");
		}
		
		String valueFindBy = attributes.get(AttributeKey.VALUE_FIND_COMPONENT_BY);
		if (valueFindBy == null) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.VALUE_FIND_BY.");
		}
		
		
		String waitFor = attributes.get(AttributeKey.WAIT_FOR);
		if (waitFor == null || waitFor.isEmpty()) {
			throw new RuntimeException(
					"Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.WAIT_FOR.");
		}
		
		Collection<WebElement> elements = Selenium.getElements(findBy, valueFindBy);
		
		if (elements == null || elements.isEmpty()) {
			waitElementReady(attributes, --attemptNumber, elements);
		}

		for (WebElement element: elements) {
			if (element.getText().trim().equals(valueFindBy)) {
				if (!element.isDisplayed()) {
					waitElementReady(attributes, --attemptNumber, elements);
				}
				
				return;
			}			
		}
	}
	
	/**
	 * Método com a função de aguardar a tela ser exibida para aplicar um
	 * determinado evento
	 * 
	 * @param attribute
	 *            Tela que sofre o evento
	 */
	default void waitElementReady(Map<AttributeKey, String> attributes, int attemptNumber, Collection<WebElement> elements) {
		// quantidade de tentativas para a exibição do elemento
		if (attemptNumber == 0) {
			throw new RuntimeException("Quantidade de tentativas excedida. Elemento não disponível");
		}
		
		String findBy = attributes.get(AttributeKey.FIND_COMPONENT_BY);
		if (findBy == null || findBy.isEmpty()) {
			throw new RuntimeException(
					"Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.FIND_BY.");
		}
		
		String valueFindBy = attributes.get(AttributeKey.VALUE_FIND_COMPONENT_BY);
		if (valueFindBy == null) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.VALUE_FIND_BY.");
		}
		
		String waitFor = attributes.get(AttributeKey.WAIT_FOR);
		if (waitFor == null || waitFor.isEmpty()) {
			throw new RuntimeException(
					"Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.WAIT_FOR.");
		}
		
		if (elements.isEmpty()) {
			waitElementReady(attributes, --attemptNumber);
		}

		for (WebElement element: elements) {
			if (element.getText().trim().equals(valueFindBy)) {
				if (!element.isDisplayed()) {
					waitElementReady(attributes, --attemptNumber);
				}
				
				return;
			}			
		}
	}
	
	public default WebElement getElementValue(Map<AttributeKey, String> attributes) {
		String findBy = attributes.get(AttributeKey.FIND_COMPONENT_BY);
		if (findBy == null) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.FIND_BY.");
		}
		
		String valueFindBy = attributes.get(AttributeKey.VALUE_FIND_COMPONENT_BY);
		if (valueFindBy == null) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.VALUE_FIND_BY.");
		}
		
		/*String componentType = attributes.get(AttributeKey.COMPONENT_TYPE);
		if (componentType == null) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.COMPONENT_TYPE.");
		}*/
		
		String attributeID = attributes.get(AttributeKey.ATTRIBUTE_ID);
		if (attributeID == null) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_ID.");
		}
		
		String attributeValue = attributes.get(AttributeKey.ATTRIBUTE_VALUE);
		if (attributeValue == null) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_VALUE.");
		}
		
		for (WebElement element : Selenium.getElements(findBy, valueFindBy)) {
			switch (attributeID ) {
				case "text":
					{
						if (element.getText().equals(attributeValue)) {
							return element;
						}
					}
					break;
				case "value":
					{
						if (element.getAttribute("value").equals(attributeValue)) {
							return element;
						}
					}
					break;
				case "title":
					{
						if (element.getAttribute("title").equals(attributeValue)) {
							return element;
						}
					}
			}
		}
		
		throw new RuntimeException("Não foi possível encontrar o elemento " + attributeValue + " pelo attributo " + attributeID + 
					".Consulta realizada via " + findBy + ": " + findBy);
	}
	
	public default WebElement getParentElement(WebElement childElement) {
		return childElement.findElement(By.xpath(".."));
	}
	
	public default WebElement getElementBySibling(Map<AttributeKey, String> attributes) {
		String findSiblingBy = attributes.get(AttributeKey.FIND_SIBLING_BY);
		if (findSiblingBy == null || findSiblingBy.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.FIND_SIBLING_BY.");
		}
		
		String siblingfindBy = attributes.get(AttributeKey.VALUE_FIND_SIBLING);
		if (siblingfindBy == null || findSiblingBy.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.VALUE_FIND_SIBLING.");
		}
		
		String attributeID = attributes.get(AttributeKey.ATTRIBUTE_ID);
		if (attributeID == null || attributeID.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_ID.");
		}
		
		String attributeValue = attributes.get(AttributeKey.ATTRIBUTE_VALUE);
		if (attributeValue == null || attributeValue.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_VALUE.");
		}
		
		Map<AttributeKey, String> siblingAttributes = new HashMap<>();
		siblingAttributes.put(AttributeKey.FIND_COMPONENT_BY, findSiblingBy);
		siblingAttributes.put(AttributeKey.VALUE_FIND_COMPONENT_BY, siblingfindBy);
		
		WebElement parent = getParentElement(this.getElementValue(siblingAttributes));
		
		for (WebElement child: parent.findElements(By.xpath("./child::*"))) {
			switch (attributeID ) 
				{
					case "text":
						{
							if (child.getText().equals(attributeValue)) {
								return child;
							}
						}
						break;
					case "value":
						{
							if (child.getAttribute("value").equals(attributeValue)) {
								return child;
							}
						}
						break;
					case "title":
						{
							if (child.getAttribute("title").equals(attributeValue)) {
								return child;
							}
						}
				}
		}
		
		throw new RuntimeException("Não ofi possível encontrar o elemento " + attributeValue);
	}
	
	public default WebElement getElement(Map<AttributeKey, String> attributes) {
		String findBy = attributes.get(AttributeKey.FIND_COMPONENT_BY);
		if (findBy == null || findBy.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.FIND_BY.");
		}
		
		String valueFindBy = attributes.get(AttributeKey.VALUE_FIND_COMPONENT_BY);
		if (valueFindBy == null || valueFindBy.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.VALUE_FIND_BY.");
		}
		
		String findAttributeBy = attributes.get(AttributeKey.FIND_ATTRIBUTE_BY);
		if (findAttributeBy == null || findAttributeBy.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.FIND_ATTRIBUTE_BY.");
		}
		
		String attributeID = attributes.get(AttributeKey.ATTRIBUTE_ID);
		if (attributeID == null || attributeID.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_ID.");
		}
		
		
		for (WebElement element: Selenium.getElements(findBy, valueFindBy)) {
			if (element.getAttribute(findAttributeBy) == null) {
				throw new RuntimeException("O elemento " + valueFindBy + " não possui o atributo " + findAttributeBy);
			}
			
			if (element.getAttribute(findAttributeBy).contains(attributeID)) {
				return element;
			}
		}
		
		throw new RuntimeException("Não foi possível encontrar o elemento com o attribute ID " + attributeID);
	}
}
