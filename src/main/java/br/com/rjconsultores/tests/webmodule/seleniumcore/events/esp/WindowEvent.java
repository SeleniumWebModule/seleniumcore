package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;

import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public interface WindowEvent extends Event {
	public default String openSession() {
		return SeleniumInstance.openSession();
	}
	
	/**
	 * Verifica se a sessão é a mesma
	 * @param sessionId Sessão 
	 * @return Retorna verdadeiro caso a sessão continue a mesma
	 */
	public default boolean validateSameSession(String sessionId) {
		return SeleniumInstance.isSameSession(sessionId);
	}
	
	public void doAction(View view, Collection<WindowRule> rules);
}
