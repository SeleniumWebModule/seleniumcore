package br.com.rjconsultores.tests.webmodule.seleniumcore.events;

public class FindBy {
	private String id;
	private String value;
	
	public FindBy(String id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
}
