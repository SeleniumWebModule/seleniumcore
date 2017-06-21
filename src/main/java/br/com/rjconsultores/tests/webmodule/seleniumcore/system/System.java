package br.com.rjconsultores.tests.webmodule.seleniumcore.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;

public class System {
	private Map<AttributeKey, String> attributes;
	private View loginView;
	private Collection<View> views;

	public System() {
		loginView = new View();
		loginView.getAttributes().put(AttributeKey.VIEW_NAME, "Login");
		
		views = new ArrayList<>();
		views.add(loginView);
	}
	
	public void validate() {
		views.forEach(view -> {
			view.validatePreLoadEvent();
			view.validateComponents();
			view.validatePosLoadEvent();
		});
	
		//SeleniumInstance.closeSession();
	}
	
	public View getLoginView() {
		return loginView;
	}
	
	public Map<AttributeKey, String> getAttributes() {
		return attributes;
	}
	
	public Collection<View> getViews() {
		return views;
	}

	public void reset() {
		attributes.clear();
		views.clear();
	}
}