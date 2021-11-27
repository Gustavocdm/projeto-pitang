package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class EmailValidacao implements Validacao<String> {

	private static final String EMAIL_PADRAO = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	@Override
	public InputInvalidoException validar(String input) {
		if (! input.matches(EMAIL_PADRAO)) {
			return new InputInvalidoException("Email inválido.");
		}
		
		return null;
	}

}
