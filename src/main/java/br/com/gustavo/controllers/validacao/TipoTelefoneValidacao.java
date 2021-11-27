package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class TipoTelefoneValidacao implements Validacao<String> {

	@Override
	public InputInvalidoException validar(String input) {
		if (input.equals("celular") || input.equals("fixo")) {			
			return null;
		}
		return new InputInvalidoException(input + " é um tipo de telefone inválido.");
	}

}
