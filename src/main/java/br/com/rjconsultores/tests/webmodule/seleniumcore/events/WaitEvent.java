package br.com.rjconsultores.tests.webmodule.seleniumcore.events;

import java.util.ArrayList;
import java.util.List;

import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Attribute;

public class WaitEvent {
	private int numAttempts;
	private List<Attribute> attributes;
	
	public WaitEvent(int numAttempts) {
		this.numAttempts = numAttempts;
		attributes = new ArrayList<>();
	}
	
	public int getNumAttempts() {
		return numAttempts;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
}
