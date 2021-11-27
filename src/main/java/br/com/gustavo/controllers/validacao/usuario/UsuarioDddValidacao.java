package br.com.gustavo.controllers.validacao.usuario;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.DddValidacao;
import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioDddValidacao extends CadastroUsuarioValidacao<Integer> {

	public UsuarioDddValidacao() {
		super(new DddValidacao());
	}

	@Override
	public InputInvalidoException validar(Usuario input) {
		InputInvalidoException validacao;
		for (Telefone telefone: input.getTelefones()) {
			validacao = super.validacaoNecessaria.validar(telefone.getDdd());
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
