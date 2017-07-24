package br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.component.keyboard.implem;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.ComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;

public class KeyboardDataRule implements ComponentRule{

	@Override
	public void validate(Component component, ComponentEvent event) {
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
