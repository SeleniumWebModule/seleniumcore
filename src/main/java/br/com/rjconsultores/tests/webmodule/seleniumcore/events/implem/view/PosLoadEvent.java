package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.KeyBoardEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class PosLoadEvent implements WindowEvent, KeyBoardEvent {

	@Override
	public void doAction(View view, Component component, Collection<Rule> rules) {
		view.getAttributes().forEach((k, v) -> {
			rules.forEach(rule -> rule.validate(view, component, this));
		});
	}
}