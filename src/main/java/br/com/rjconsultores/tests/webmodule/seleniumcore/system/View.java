package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.WaitFor;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.WindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view.PosLoadWindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.view.PreLoadWindowEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.WindowRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem.RuleViewPosLoad;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem.RuleViewPreLoad;

public class View {
	private String sessionId;
	
	private Map<AttributeKey, String> attributes;
	
	private Collection<Component> components;
	private Collection<WindowEvent> events;
	private Collection<WindowRule> rulesPreLoad;
	private Collection<WindowRule> rulesPosLoad;
	
	private int attemptNumber;

	public View() {
		attributes = new HashMap<>();
		attributes.put(AttributeKey.WAIT_FOR, WaitFor.VIEW.name());
		
		components = new ArrayList<>();
		events = new ArrayList<>();
		
		rulesPreLoad = new ArrayList<>();
		rulesPreLoad.add(new RuleViewPreLoad());
		
		rulesPosLoad = new ArrayList<>();
		rulesPosLoad.add(new RuleViewPosLoad());
		
		attemptNumber = 99999;
	}

	public void validatePreLoadEvent() {
		WindowEvent preLoad = new PreLoadWindowEvent();
		preLoad.doAction(this, rulesPreLoad);
	}

	public void validateComponents() {
		for (Component component : components) {
			component.validate(this);
		}
	}

	public void validatePosLoadEvent() {
		WindowEvent posLoad = new PosLoadWindowEvent();
		posLoad.doAction(this, rulesPosLoad);
	}

	public Collection<Component> getComponents() {
		return components;
	}

	public Map<AttributeKey, String> getAttributes() {
		return attributes;
	}

	public Collection<WindowEvent> getEvents() {
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
	
	public Collection<WindowRule> getRulesPreLoad() {
		return rulesPreLoad;
	}
	
	public Collection<WindowRule> getRulesPosLoad() {
		return rulesPosLoad;
	}
}