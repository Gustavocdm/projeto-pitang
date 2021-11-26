package br.com.gustavo.controllers.validacao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.exceptions.TipoInputInvalidoException;
import br.com.gustavo.dominio.model.Usuario;

@RequestScoped
public class CadastroUsuarioValidacao implements Validacao, Serializable {
	private static final long serialVersionUID = 1L;
		
	@Override
	public InputInvalidoException validar(Object input) throws TipoInputInvalidoException {
		if (! (input instanceof Usuario)) {
			throw new TipoInputInvalidoException("Input não é do tipo Usuario");
		}
		
		Usuario usuario = (Usuario) input;
		
		
		
		return null;
	}

}
