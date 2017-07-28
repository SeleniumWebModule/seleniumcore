package br.com.rjconsultores.tests.webmodule.seleniumcore.events;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.IdentifyBy;

public class FindBy {
	private IdentifyBy identifyBy;
	private String value;
	
	public FindBy(IdentifyBy identifyBy, String value) {
		this.value = value;
		this.identifyBy = identifyBy;
	}
	
	public String getValue() {
		return value;
	}
	
	public IdentifyBy getIdentifyBy() {
		return identifyBy;
	}
}
