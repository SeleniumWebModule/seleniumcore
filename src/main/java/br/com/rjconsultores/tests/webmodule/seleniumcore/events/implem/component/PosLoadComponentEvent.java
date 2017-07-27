package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.ComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Attribute;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public class PosLoadComponentEvent implements ComponentEvent{

	@Override
	public void doAction(Component component, Collection<ComponentRule> rules) {
		if (component.getWaitEvent() != null) {
			for (Attribute attribute: component.getWaitEvent().getAttributes())
			this.waitElementReady(attribute, component.getWaitEvent().getNumAttempts());
		}
	}
}
