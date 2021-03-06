package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.WaitEvent;
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
	private Collection<ComponentRule> rulesPreLoad;
	private Collection<ComponentRule> rulesPosLoad;
	private Set<Component> childs;
	
	private WebElement reference;
	
	private WaitEvent waitEvent;

	public Component() {
		rules = new ArrayList<>();
		events = new ArrayList<>();
		
		rulesPreLoad = new ArrayList<>();
		rulesPreLoad.add(new RuleComponentPreLoad());
		
		rulesPosLoad = new ArrayList<>();
		rulesPosLoad.add(new RuleComponentPosLoad());
		
		attributes = new HashMap<>();
		childs = new HashSet<>();
	}
	
	public Component(WebElement reference) {
		this();
		this.reference = reference;		
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

	public Collection<ComponentRule> getRules() {
		return rules;
	}

	public Collection<ComponentEvent> getEvents() {
		return events;
	}
	
	public WaitEvent getWaitEvent() {
		return waitEvent;
	}
	
	public void registerWaitEvent(WaitEvent waitEvent) {
		this.waitEvent = waitEvent;
	}
	
	public Map<AttributeKey, String> getAttributes() {
		return attributes;
	}
	
	public void addReference(WebElement reference) {
		this.reference = reference;
	}
	
	public WebElement getReference() {
		return reference;
	}
	
	public void registerChilds(Set<Component> childs) {
		this.childs = childs;
	}
	
	public Set<Component> getChilds() {
		return childs;
	}
}
