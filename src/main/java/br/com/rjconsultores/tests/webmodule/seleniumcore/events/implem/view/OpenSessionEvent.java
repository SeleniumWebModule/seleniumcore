package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view;

import java.util.Collection;
import java.util.Map;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class OpenSessionEvent implements WindowEvent {

	@Override
	public void doAction(View view, Collection<WindowRule> rules) {
		view.setSessionId(this.openSession());
	}
	
	@Override
	public WebElement getElement(Map<AttributeKey, String> attributes) {
		return null;
	}
}
