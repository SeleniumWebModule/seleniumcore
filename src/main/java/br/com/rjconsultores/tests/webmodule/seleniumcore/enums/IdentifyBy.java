package br.com.rjconsultores.tests.webmodule.seleniumcore.enums;

import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByName;


public enum IdentifyBy {
	CLASS_NAME(ByClassName.class.getSimpleName()),
	TAG_NAME(ByTagName.class.getSimpleName()),
	NAME(ByName.class.getSimpleName());
	
	private String description;
	
	private IdentifyBy(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
