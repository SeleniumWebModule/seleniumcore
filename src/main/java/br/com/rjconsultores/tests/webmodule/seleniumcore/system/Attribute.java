package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.IdentifyBy;

public class Attribute {
	private String id;
	private String value;
	private IdentifyBy identifyBy;
	
	public Attribute(String id, String value, IdentifyBy identifyBy) {
		this.id = id;
		this.value = value;
		this.identifyBy = identifyBy;
	}
	
	public String getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
	
	public IdentifyBy getIdentifyBy() {
		return identifyBy;
	}
}
