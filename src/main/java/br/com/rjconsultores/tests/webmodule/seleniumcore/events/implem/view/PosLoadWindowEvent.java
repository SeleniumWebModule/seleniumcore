package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class PosLoadWindowEvent implements WindowEvent {

	@Override
	public void doAction(View view, Collection<WindowRule> rules) {
		view.getAttributes().forEach((k, v) -> {
			rules.forEach(rule -> rule.validate(view, this));
		});			
	}
}