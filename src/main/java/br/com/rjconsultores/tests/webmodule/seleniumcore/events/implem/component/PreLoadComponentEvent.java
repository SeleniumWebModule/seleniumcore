package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.ComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public class PreLoadComponentEvent implements ComponentEvent{

	@Override
	public void doAction(Component component, Collection<ComponentRule> rules) {
		if (component.getWaitEvent() !=null) {
			component.getWaitEvent().getAttributes().forEach(attribute -> {
				this.waitElementReady(attribute, component.getWaitEvent().getNumAttempts());								
			});
		}
	}
}
