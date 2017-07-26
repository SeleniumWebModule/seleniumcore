package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public interface ComponentEvent extends Event {
	
	/**
	 * O Evento pertence a view, mas recebe o componente que sofrerá as ações do
	 * evento
	 * 
	 * @param component
	 */
	public void doAction(Component component, Collection<ComponentRule> rules);
}
