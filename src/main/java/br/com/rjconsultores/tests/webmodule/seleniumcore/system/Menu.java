package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

public class Menu {
	private String name;
	private Menu parent;

	public Menu(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
}
