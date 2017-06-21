package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.Event;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class RulePosLoad implements Rule{

	@Override
	public void validate(View view, Component component, Event event) {
		if (view.getAttributes().containsKey(AttributeKey.VIEW_NAME) && view.getAttributes().get(AttributeKey.VIEW_NAME).equals("Login")) {
			return;
		}
		
		if (view.getAttributes().containsKey(AttributeKey.WAIT_FOR)) {
			event.waitElementReady(view.getAttributes(), view.getAttemptNumber());
			return;
		}
		
		if (component.getAttributes().containsKey(AttributeKey.WAIT_FOR)) {
			event.waitElementReady(component.getAttributes(), component.getAttemptNumber());
			return;
		}
	}
}
