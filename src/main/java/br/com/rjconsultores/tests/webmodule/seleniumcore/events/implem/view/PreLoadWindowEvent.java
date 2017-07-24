package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class PreLoadWindowEvent implements WindowEvent {

	@Override
	public void doAction(View view, Collection<WindowRule> rules) {
		if (view != null) {			
			rules.forEach(rule -> rule.validate(view, this));
			return;
		}
		
		rules.forEach(rule -> rule.validate(view, this));
	}
}
