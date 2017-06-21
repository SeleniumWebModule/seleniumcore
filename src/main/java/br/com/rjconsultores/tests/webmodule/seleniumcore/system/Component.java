package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.Event;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;

public class Component {
	private Map<AttributeKey, String> attributes;
	private Collection<Event> events;
	private Collection<Rule> rules;
	private int attemptNumber;

	public Component() {
		attributes = new HashMap<>();
		rules = new ArrayList<>();
		events = new ArrayList<>();
		attemptNumber = 1000;
	}

	public void validate(View view) {
		events.forEach(event -> event.doAction(view, this, rules));
	}

	public Map<AttributeKey, String> getAttributes() {
		return attributes;
	}

	public Collection<Rule> getRules() {
		return rules;
	}

	public Collection<Event> getEvents() {
		return events;
	}
	
	public int getAttemptNumber() {
		return attemptNumber;
	}
	
	public void setAttemptNumber(int attemptNumber) {
		this.attemptNumber = attemptNumber;
	}
}
