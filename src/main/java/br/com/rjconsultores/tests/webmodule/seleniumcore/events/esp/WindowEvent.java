package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;
import java.util.Map;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public interface WindowEvent extends Event {
	public default String openSession() {
		return SeleniumInstance.openSession();
	}
	
	/**
	 * Verifica se a sess�o � a mesma
	 * @param sessionId Sess�o 
	 * @return Retorna verdadeiro caso a sess�o continue a mesma
	 */
	public default boolean validateSameSession(String sessionId) {
		return SeleniumInstance.isSameSession(sessionId);
	}
	
	@Override
	default WebElement getElement(Map<AttributeKey, String> attributes) {
		throw new RuntimeException("N�o implementado!!");
	}
	
	/**
	 * M�todo exclusivo para a interface Event.
	 */
	@Override
	default void waitElementReady(Map<AttributeKey, String> attributes, int attemptNumber, Collection<WebElement> elements) {
		throw new RuntimeException("Voc� n�o tem permiss�o para utilizar esse m�todo. Utilize waitElementRead sem elements");
	}
	
	public void doAction(View view, Collection<WindowRule> rules);
}
