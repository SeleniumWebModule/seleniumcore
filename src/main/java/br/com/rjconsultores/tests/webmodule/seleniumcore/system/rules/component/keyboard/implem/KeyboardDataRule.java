package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.component.keyboard.implem;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.Event;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class KeyboardDataRule implements Rule{

	@Override
	public void validate(View view, Component component, Event event) {
		/*this.
		SeleniumElement.findElementAndGetVa(component.getAttributes());*/

	}
	
	
	/*private void validateAttrInfo(Component component) {
		
		
		for (Attribute attr: component.getAttributes()) {
			
			SeleniumElement.getElements(attr.getIdentifier()).forEach(elem -> {
				String attrView = elem.getText();
				
				if (!attrView.equals(attr.getValue())) {
					throw new RuntimeException("O atributo informado não é o mesmo que foi inserido na tela.");
				}	
				
			});

		}
	}*/
}
