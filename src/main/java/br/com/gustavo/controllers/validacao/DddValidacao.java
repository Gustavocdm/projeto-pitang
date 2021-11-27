package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class DddValidacao implements Validacao<Integer> {

	@Override
	public InputInvalidoException validar(Integer input) {
		if (input > 9 && input < 100) {			
			return null;
		}
		return new InputInvalidoException(input + " é um DDD inválido.");
	}

}
