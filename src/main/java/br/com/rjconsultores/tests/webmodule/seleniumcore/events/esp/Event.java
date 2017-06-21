package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Collection;
import java.util.Map;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.WaitFor;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public interface Event {
	
	/**
	 * Método com a função de aguardar a tela ser exibida para aplicar um
	 * determinado evento
	 * 
	 * @param attribute
	 *            Tela que sofre o evento
	 */
	default void waitElementReady(Map<AttributeKey, String> attributes, int attemptNumber) {
		// quantidade de tentativas para a exibição do elemento
		if (attemptNumber == 0) {
			throw new RuntimeException("Quantidade de tentativas excedida. Elemento não disponível");
		}
		
		String componentName = attributes.get(AttributeKey.COMPONENT_NAME);
		System.out.println("Aguardando attribute ID: " + componentName);
		
		Collection<WebElement> elements = Selenium.getElements(componentName);
		
		if (elements.isEmpty()) {
			waitElementReady(attributes, --attemptNumber);
		}
		
		String waitFor = attributes.get(AttributeKey.WAIT_FOR);

		if (waitFor != null && waitFor.equals(WaitFor.VIEW.name())) {
			String viewName = attributes.get(AttributeKey.VIEW_NAME);
			
			for (WebElement element: elements) {
				if (element.getText().trim().equals(viewName)) {
					if (!element.isDisplayed()) {
						waitElementReady(attributes, --attemptNumber);
					}
					
					return;
				}			
			}
		}
	}
	
	public default WebElement getElement(Map<AttributeKey, String> attributes) {
		return Selenium.getElement(attributes);
	}

	/**
	 * O Evento pertence a view, mas recebe o componente que sofrerá as ações do
	 * evento
	 * 
	 * @param component
	 */
	public void doAction(View view, Component component, Collection<Rule> rules);
}
