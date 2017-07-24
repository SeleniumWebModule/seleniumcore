package br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.RuleEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public interface WindowRule extends RuleEvent{
	public void validate(View view, WindowEvent event);
}
