package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class NumeroTelefoneValidacao implements Validacao<String> {

	@Override
	public InputInvalidoException validar(String input) {
		if (input.matches("[0-9]{8,9}")) {			
			return null;
		}
		return new InputInvalidoException(input + " é um número de telefone inválido.");
	}

}
