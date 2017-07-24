package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;
import java.util.Map;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public interface ComponentEvent extends Event {
	
	@Override
	default void waitElementReady(Map<AttributeKey, String> attributes, int attemptNumber, Collection<WebElement> elements) {
		throw new RuntimeException("Você não tem permissão para utilizar esse método. Utilize waitElementRead sem elements");
	}
	
	/**
	 * O Evento pertence a view, mas recebe o componente que sofrerá as ações do
	 * evento
	 * 
	 * @param component
	 */
	public void doAction(Component component, Collection<ComponentRule> rules);
}
