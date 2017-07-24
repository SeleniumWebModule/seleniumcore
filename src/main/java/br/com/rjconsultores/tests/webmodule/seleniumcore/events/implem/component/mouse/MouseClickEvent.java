package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component.mouse;

import java.util.Collection;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.MouseEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public class MouseClickEvent implements MouseEvent {

	@Override
	public void doAction(Component component, Collection<ComponentRule> rules) {
		WebElement element = this.getElement(component.getAttributes());
		element.click();

		rules.forEach(rule -> rule.validate(component, this));
	}
}
