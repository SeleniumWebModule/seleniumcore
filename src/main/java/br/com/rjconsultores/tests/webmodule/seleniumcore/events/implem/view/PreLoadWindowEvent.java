package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class PreLoadWindowEvent implements WindowEvent {

	@Override
	public void doAction(View view, Collection<WindowRule> rules) {
		if (view.getAttributes().containsKey(AttributeKey.VIEW_NAME) && !view.getAttributes().get(AttributeKey.VIEW_NAME).equals("Login")) {
			view.registerChilds(this.getChilds(this.getElement(view.getAttributes())));					
		}
		
		rules.forEach(rule -> rule.validate(view, this));
	}
}
