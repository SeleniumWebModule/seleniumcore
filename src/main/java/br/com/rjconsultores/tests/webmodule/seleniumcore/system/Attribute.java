package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import br.com.rjconsultores.tests.webmodule.seleniumcore.events.FindBy;

public class Attribute {
	private String id;
	private String value;
	private FindBy findBy;
	private boolean waitForAttribute;
	
	public Attribute(String id, String value, FindBy findBy) {
		this.id = id;
		this.value = value;
		this.findBy = findBy;
		this.waitForAttribute = true;
	}
	
	public Attribute(FindBy findBy) {
		this.findBy = findBy;
		this.waitForAttribute = false;
	}
	
	public String getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
	
	public FindBy getFindBy() {
		return findBy;
	}
	
	public boolean mustWait() {
		return waitForAttribute;
	}
}
