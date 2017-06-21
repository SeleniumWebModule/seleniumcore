package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

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
}
