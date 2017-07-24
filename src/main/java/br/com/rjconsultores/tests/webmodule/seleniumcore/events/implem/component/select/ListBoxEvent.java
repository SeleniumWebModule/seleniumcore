package br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component.select;

import java.util.Collection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.ComboBoxEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class ListBoxEvent implements ComboBoxEvent {
	public void doAction(View view, Component component, Collection<WindowRule> rules) {
		String attributeValue = component.getAttributes().get(AttributeKey.ATTRIBUTE_VALUE);

		if (attributeValue == null || attributeValue.isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.ATTRIBUTE_VALUE.");
		}
		
		if (component.getAttributes().get(AttributeKey.SELECT_IDXVALUE) == null || component.getAttributes().get(AttributeKey.SELECT_IDXVALUE).isEmpty()) {
			throw new RuntimeException("Você não passou o elemento necessário para essa operação. Configure o atributo AttributeKey.SELECT_IDXVALUE.");
		}
		
		int idxValue = Integer.parseInt(component.getAttributes().get(AttributeKey.SELECT_IDXVALUE));
		
		
		WebElement element = this.getElementBySibling(component.getAttributes());
		
		populateCombo(idxValue, attributeValue.substring(0,1), element);				
	}
	
	private void populateCombo(int attempt,String value, WebElement element) {	
		element.sendKeys(value);
		
		for (;attempt > 0;--attempt) {
			element.sendKeys(Keys.ARROW_DOWN);
		}	
		
		element.sendKeys(Keys.ENTER);
	}
}
