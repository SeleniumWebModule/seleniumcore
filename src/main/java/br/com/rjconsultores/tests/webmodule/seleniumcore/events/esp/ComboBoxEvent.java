package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public interface ComboBoxEvent extends Event {

	public default void doAction(View view, Component component, Collection<WindowRule> rules) {
		
		/*String siblingName = component.getAttributes().get(AttributeKey.SIBLING_NAME);

		if (siblingName == null || siblingName.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.SIBLING_NAME.");
		}
		
		String attributeValue = component.getAttributes().get(AttributeKey.ATTRIBUTE_VALUE);

		if (attributeValue == null || attributeValue.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_VALUE.");
		}
		
		if (component.getAttributes().get(AttributeKey.SELECT_IDXVALUE) == null || component.getAttributes().get(AttributeKey.SELECT_IDXVALUE).isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.SELECT_IDXVALUE.");
		}
		
		int idxValue = Integer.parseInt(component.getAttributes().get(AttributeKey.SELECT_IDXVALUE));
		
		String parentElement = component.getAttributes().get(AttributeKey.PARENT_ELEMENT);
		
		if (parentElement == null || parentElement.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.PARENT_ELEMENT.");
		}
		
		WebElement searchParent = null;
		
		Collection<WebElement> elements = Selenium.getElements(parentElement);
		
		Iterator<WebElement> itWebElement = elements.iterator();

		while (itWebElement.hasNext()) {
			WebElement parent = itWebElement.next();
			List<WebElement> childElements = parent.findElements(By.xpath("./child::*"));
			for (WebElement e  : childElements)
			{
				String child = e.getText();
				if (child.equals(siblingName)) {
					searchParent = parent.findElement(By.xpath(".."));
					WebElement target = searchParent.findElement(By.tagName("input"));

					populateCombo(idxValue, attributeValue.substring(0,1), target);
					
					if (target.getAttribute("value").equals(attributeValue)) {
						return;
					}					
				}
			}				
		}
	}
	
	
	
	@Override
	default WebElement getElement(Map<AttributeKey, String> attributes) {
		String siblingName = attributes.get(AttributeKey.SIBLING_NAME);

		if (siblingName == null || siblingName.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.SIBLING_NAME.");
		}
		
		String attributeID = attributes.get(AttributeKey.ATTRIBUTE_ID);
		if (attributeID == null || attributeID.isEmpty()) {
			throw new RuntimeException(
					"Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_ID.");
		}
		
		String attributeValue = attributes.get(AttributeKey.ATTRIBUTE_VALUE);
		if (attributeValue == null || attributeValue.isEmpty()) {
			throw new RuntimeException(
					"Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_VALUE.");
		}
		
		Selenium.getElements(componentName)
		
		if (attributes.get(AttributeKey.SELECT_IDXVALUE) == null || attributes.get(AttributeKey.SELECT_IDXVALUE).isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.SELECT_IDXVALUE.");
		}
		
		//int idxValue = Integer.parseInt(attributes.get(AttributeKey.SELECT_IDXVALUE));
		
		String parentElement = attributes.get(AttributeKey.PARENT_ELEMENT);
		
		if (parentElement == null || parentElement.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.PARENT_ELEMENT.");
		}
		
		//attributes.put(AttributeKey.COMPONENT_TYPE, "comboBox");
		
		
		
		return this.getElement(attributes);
	}
	
	default	WebElement getParentElement(Map<AttributeKey, String> attributes) {
		String findBy = attributes.get(AttributeKey.FIND_BY);
		
		WebElement element = this.getElement(attributes);
		
		
		
		
		
		return null;*/
	
	}
	
}
