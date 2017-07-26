package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp.ComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component.PosLoadComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component.PreLoadComponentEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.rules.esp.ComponentRule;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.component.implem.RuleComponentPosLoad;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.component.implem.RuleComponentPreLoad;


public class Component {
	private Map<AttributeKey, String> attributes;
	private Collection<ComponentEvent> events;
	private Collection<ComponentRule> rules;
	private int attemptNumber;
	private Collection<ComponentRule> rulesPreLoad;
	private Collection<ComponentRule> rulesPosLoad;

	public Component() {
		attributes = new HashMap<>();
		rules = new ArrayList<>();
		events = new ArrayList<>();
		
		rulesPreLoad = new ArrayList<>();
		rulesPreLoad.add(new RuleComponentPreLoad());
		
		rulesPosLoad = new ArrayList<>();
		rulesPosLoad.add(new RuleComponentPosLoad());
		
		attemptNumber = 99999;
	}
	
	public void validatePreLoadEvent() {
		ComponentEvent preLoad = new PreLoadComponentEvent();
		preLoad.doAction(this, rulesPreLoad);
	}

	public void validate() {
		this.validatePreLoadEvent();
		events.forEach(event -> event.doAction(this, rules));
		this.validatePosLoadEvent();
	}
	
	public void validatePosLoadEvent() {
		ComponentEvent posLoad = new PosLoadComponentEvent();
		posLoad.doAction(this, rulesPosLoad);
	}

	public Map<AttributeKey, String> getAttributes() {
		return attributes;
	}

	public Collection<ComponentRule> getRules() {
		return rules;
	}

	public Collection<ComponentEvent> getEvents() {
		return events;
	}
	
	public int getAttemptNumber() {
		return attemptNumber;
	}
	
	public void setAttemptNumber(int attemptNumber) {
		this.attemptNumber = attemptNumber;
	}
}
