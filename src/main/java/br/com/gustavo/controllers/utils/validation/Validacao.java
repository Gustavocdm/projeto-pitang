package br.com.gustavo.controllers.utils.validation;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.exceptions.TipoInputInvalidoException;

public interface Validacao {
	public InputInvalidoException validar(Object input)  throws TipoInputInvalidoException;
}
