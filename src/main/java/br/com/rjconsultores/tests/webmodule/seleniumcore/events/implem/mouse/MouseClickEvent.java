package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.mouse;

import java.util.Collection;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.MouseEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class MouseClickEvent implements MouseEvent {

	@Override
	public void doAction(View view, Component component, Collection<Rule> rules) {
		WebElement element = this.getElement(component.getAttributes());
		element.click();

		rules.forEach(rule -> rule.validate(view, component, this));
	}

}
