package br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.ComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.RuleEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public interface ComponentRule extends RuleEvent{
	public void validate(Component component, ComponentEvent event);
}
