package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.Event;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public interface Rule {
	public void validate(View view, Component component, Event event);
}
