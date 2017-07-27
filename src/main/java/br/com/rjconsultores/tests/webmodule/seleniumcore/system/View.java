package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.WaitEvent;
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
	
	private WaitEvent waitEvent;

	public View() {
		attributes = new HashMap<>();
		
		components = new ArrayList<>();
		events = new ArrayList<>();
		
		rulesPreLoad = new ArrayList<>();
		rulesPreLoad.add(new RuleViewPreLoad());
		
		rulesPosLoad = new ArrayList<>();
		rulesPosLoad.add(new RuleViewPosLoad());
	}

	public void validatePreLoadEvent() {
		WindowEvent preLoad = new PreLoadWindowEvent();
		preLoad.doAction(this, rulesPreLoad);
	}

	public void validateComponents() {
		for (Component component : components) {
			component.validate();
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
	
	public Collection<WindowRule> getRulesPreLoad() {
		return rulesPreLoad;
	}
	
	public Collection<WindowRule> getRulesPosLoad() {
		return rulesPosLoad;
	}
	
	public WaitEvent getWaitEvent() {
		return waitEvent;
	}
	
	public void doWait(WaitEvent waitEvent) {
		this.waitEvent = waitEvent;
	}
}