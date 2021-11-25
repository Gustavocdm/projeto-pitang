package br.com.gustavo.controllers.utils.validation;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.exceptions.TipoInputInvalidoException;
import br.com.gustavo.dominio.model.Telefone;

public class TelefoneValidacao implements Validacao {;

	@Override
	public InputInvalidoException validar(Object input) throws TipoInputInvalidoException {
		if (! (input instanceof Telefone)) {
			throw new TipoInputInvalidoException("Input não é do tipo Telefone");
		}
		
		Telefone telefone = (Telefone) input;
		
		if (! validarDDD(telefone.getDdd())) {
			return new InputInvalidoException("DDD " + telefone.getDdd() + " é inválido");
		}
		if (! validarNumero(telefone.getNumero())) {
			return new InputInvalidoException("O número de telefone " + telefone.getNumero() + " é inválido");
		}
		if (! validarTipo(telefone.getTipo())) {
			return new InputInvalidoException("O telefone só pode ser fixo ou celular.");
		}
		return null;
	}
	
	private boolean validarDDD(Integer ddd) {
		return ddd > 10 && ddd < 100;
	}
	
	private boolean validarNumero(String numero) {
		return numero.matches("[0-9]{8,9}");
	}
	
	private boolean validarTipo(String tipo) {
		return tipo.equals("celular") || tipo.equals("fixo");
	}

}
