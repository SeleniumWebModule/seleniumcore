package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.keyboard;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.KeyBoardEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class KeyPressEvent implements KeyBoardEvent {

	@Override
	public void doAction(View view, Component component, Collection<Rule> rules) {
		this.doInputValue(view, component, rules);
	}
}
