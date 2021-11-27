package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class StringNaoNulaValidacao implements Validacao<String> {
	
	private String inputName;
	
	public StringNaoNulaValidacao(String inputName) {
		this.inputName = inputName;
	}
	
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	
	@Override
	public InputInvalidoException validar(String input) {
		if (input == null || input.length() == 0) {
			return new InputInvalidoException("O campo " + inputName + " é requerido.");
		}
		
		return null;
	}

}
