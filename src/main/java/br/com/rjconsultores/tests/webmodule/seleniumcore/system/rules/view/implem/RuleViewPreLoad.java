package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class RuleViewPreLoad implements WindowRule {

	@Override
	public void validate(View view, WindowEvent event) {
		WindowEvent windowEvent = (WindowEvent) event;
		view.setSessionId(windowEvent.openSession());
		
		if (view.getAttributes().containsKey(AttributeKey.VIEW_NAME) && view.getAttributes().get(AttributeKey.VIEW_NAME).equals("Login")) {
			return;
		}
	}
}
