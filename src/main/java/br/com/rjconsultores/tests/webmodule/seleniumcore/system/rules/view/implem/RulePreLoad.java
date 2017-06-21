package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.Event;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class RulePreLoad implements Rule {

	@Override
	public void validate(View view, Component component, Event event) {
		WindowEvent windowEvent = (WindowEvent) event;
		view.setSessionId(windowEvent.openSession());
	}
}
