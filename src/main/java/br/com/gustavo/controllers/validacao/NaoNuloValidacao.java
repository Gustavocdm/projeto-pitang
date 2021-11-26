package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.exceptions.TipoInputInvalidoException;

public class NaoNuloValidacao implements Validacao {
	
	private String inputName;
	
	public NaoNuloValidacao(String inputName) {
		this.inputName = inputName;
	}

	@Override
	public InputInvalidoException validar(Object input) throws TipoInputInvalidoException {
		if (! (input instanceof String)) {
			throw new TipoInputInvalidoException("Input não é do tipo String");
		}
		
		String inputString = (String) input;
		
		if (inputString == null || inputString.length() == 0) {
			return new InputInvalidoException("O campo " + inputName + " é requerido.");
		}
		
		return null;
	}

}
