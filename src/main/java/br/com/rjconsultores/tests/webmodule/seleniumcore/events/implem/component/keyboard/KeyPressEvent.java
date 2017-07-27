package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component.keyboard;

import java.util.Collection;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.KeyBoardEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public class KeyPressEvent implements KeyBoardEvent {

	@Override
	public void doAction(Component component, Collection<ComponentRule> rules) {
		
		if (component.getAttributes().containsKey(AttributeKey.FIND_PARENT_BY)) {
			WebElement element = this.getElementBySibling(component.getAttributes());
			element.sendKeys(component.getAttributes().get(AttributeKey.ATTRIBUTE_VALUE));
			
			rules.forEach(rule -> rule.validate(component, this));
			return;
		}
		
		WebElement element = this.getElement(component.getAttributes());
		element.sendKeys(component.getAttributes().get(AttributeKey.ATTRIBUTE_VALUE));
		
		rules.forEach(rule -> rule.validate(component, this));
	}
}
