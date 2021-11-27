package br.com.gustavo.controllers.validacao.usuario;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.StringNaoNulaValidacao;
import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioComEmailValidacao extends CadastroUsuarioValidacao<String> {

	public UsuarioComEmailValidacao() {
		super(new StringNaoNulaValidacao("email"));
	}

	@Override
	public InputInvalidoException validar(Usuario input) {
		InputInvalidoException validacao;
		for (Telefone telefone: input.getTelefones()) {
			validacao = super.validacaoNecessaria.validar(telefone.getNumero());
			if (validacao != null) {
				return validacao;
			}
		}
		if (super.proximaValidacao != null) {
			return super.proximaValidacao.validar(input);
		}
		return null;
	}

}
