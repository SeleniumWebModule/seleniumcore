package br.com.rjconsultores.tests.webmodule.seleniumcore.testsuit;

import java.util.List;

import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class TestCase {
	private View view;
	private Integer maxLengthInput;
	
	public TestCase(String viewName) {
		//view = new View(viewName);
	}
	
	/**
	 * 
	 * @param values valores para os testes em massa para um determinado componente
	 * @param target Componente alvo dos valores que foram passados por parametro
	 */
	public void testInputData(List<String> values, Component target) {
		view.getComponents().add(target);
	}
	
	public void setMaxLengthInput(Integer maxLengthInput) {
		this.maxLengthInput = maxLengthInput;
	}
	
	public Integer getMaxLengthInput() {
		return maxLengthInput;
	}
}
