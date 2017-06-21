package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public interface KeyBoardEvent extends Event {
	
	/**
	 * Faz a inserção dos valores em um campo input
	 * @param view Tela que contém o componente
	 * @param component Componente que acionará o evento
	 * @param rules regra a ser aplicada no evento
	 */
	public default void doInputValue(View view, Component component, Collection<Rule> rules) {
		Selenium.findElementAndSendKey(component.getAttributes());
		rules.forEach(rule -> rule.validate(view, component, this));
	}
	
	public default String getInputValue(Map<AttributeKey, String> attributes) {
		return Selenium.findElementAndGetValue(attributes);
	}
}
