package br.com.gustavo.controllers.validacao;

import javax.enterprise.context.RequestScoped;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.exceptions.TipoInputInvalidoException;

@RequestScoped
public class EmailValidacao implements Validacao {

	private static final String EMAIL_PADRAO = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	@Override
	public InputInvalidoException validar(Object input) throws TipoInputInvalidoException {
		if (! (input instanceof String)) {
			throw new TipoInputInvalidoException("Input não é do tipo Telefone");
		}
		
		String email = (String) input;
		
		if (! email.matches(EMAIL_PADRAO)) {
			return new InputInvalidoException("Email inválido.");
		}
		
		return null;
	}

}
