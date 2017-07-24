package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.component.implem;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.ComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public class RuleComponentPosLoad implements ComponentRule{

	@Override
	public void validate(Component component, ComponentEvent event) {
		if (component.getAttributes().containsKey(AttributeKey.WAIT_FOR)) {
			event.waitElementReady(component.getAttributes(), component.getAttemptNumber());
		}
	}
}
