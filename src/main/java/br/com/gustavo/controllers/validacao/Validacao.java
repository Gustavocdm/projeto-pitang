package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public interface Validacao <T> {
	public InputInvalidoException validar(T input);
}
