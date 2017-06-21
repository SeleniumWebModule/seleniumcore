package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem;

import java.util.HashMap;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.Event;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class RuleLogin implements Rule {

	@Override
	public void validate(View view, Component component, Event event) {
		WindowEvent windowEvent = (WindowEvent) event;

		if (!windowEvent.validateSameSession(view.getSessionId())) {
			Map<AttributeKey, String> attributes = new HashMap<>();
			attributes.put(AttributeKey.COMPONENT_NAME, "z-menubar-hor");
			windowEvent.waitElementReady(attributes, view.getAttemptNumber());
		}
	}
}
