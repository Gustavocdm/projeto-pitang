package br.com.gustavo.controllers.validacao.usuario;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.EmailValidacao;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioEmailFormatoValidacao extends CadastroUsuarioValidacao<String> {
	
	public UsuarioEmailFormatoValidacao() {
		super(new EmailValidacao());
	}

	@Override
	public InputInvalidoException validar(Usuario input) {
		InputInvalidoException validacao = super.validacaoNecessaria.validar(input.getEmail());
		
		if (validacao == null && super.proximaValidacao != null) {
			return super.proximaValidacao.validar(input);
		}
		
		return validacao;
	}


}
