package br.com.gustavo.controllers.validacao.usuario;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.StringNaoNulaValidacao;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioNumeroTelefoneNaoVazioValidacao extends CadastroUsuarioValidacao<String> {

	public UsuarioNumeroTelefoneNaoVazioValidacao() {
		super(new StringNaoNulaValidacao("telefone"));
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
