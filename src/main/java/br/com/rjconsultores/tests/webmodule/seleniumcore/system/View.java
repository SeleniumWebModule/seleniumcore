package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.WaitFor;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.Event;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view.PosLoadEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view.PreLoadEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.esp.Rule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem.RulePosLoad;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem.RulePreLoad;

public class View {
	private String sessionId;
	
	private Map<AttributeKey, String> attributes;
	
	private Collection<Component> components;
	private Collection<Event> events;
	private Collection<Rule> rulesPreLoad;
	private Collection<Rule> rulesPosLoad;
	
	private int attemptNumber;

	public View() {
		attributes = new HashMap<>();
		attributes.put(AttributeKey.WAIT_FOR, WaitFor.VIEW.name());
		
		components = new ArrayList<>();
		events = new ArrayList<>();
		
		rulesPreLoad = new ArrayList<>();
		rulesPreLoad.add(new RulePreLoad());
		
		rulesPosLoad = new ArrayList<>();
		rulesPosLoad.add(new RulePosLoad());
		
		attemptNumber = 1000;
	}

	public void validatePreLoadEvent() {
		Event preLoad = new PreLoadEvent();
		preLoad.doAction(this, null, rulesPreLoad);
	}

	public void validateComponents() {
		for (Component component : components) {
			component.validate(this);
		}
	}

	public void validatePosLoadEvent() {
		Event posLoad = new PosLoadEvent();
		posLoad.doAction(this, null, rulesPosLoad);
	}

	public Collection<Component> getComponents() {
		return components;
	}

	public Map<AttributeKey, String> getAttributes() {
		return attributes;
	}

	public Collection<Event> getEvents() {
		return events;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public int getAttemptNumber() {
		return attemptNumber;
	}
	
	public Collection<Rule> getRulesPreLoad() {
		return rulesPreLoad;
	}
	
	public Collection<Rule> getRulesPosLoad() {
		return rulesPosLoad;
	}
}