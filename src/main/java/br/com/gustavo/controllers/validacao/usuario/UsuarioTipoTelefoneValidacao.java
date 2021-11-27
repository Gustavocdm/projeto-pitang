package br.com.gustavo.controllers.validacao.usuario;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.TipoTelefoneValidacao;
import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioTipoTelefoneValidacao extends CadastroUsuarioValidacao<String> {

	public UsuarioTipoTelefoneValidacao() {
		super(new TipoTelefoneValidacao());
	}

	@Override
	public InputInvalidoException validar(Usuario input) {
		InputInvalidoException validacao;
		for (Telefone telefone: input.getTelefones()) {
			validacao = super.validacaoNecessaria.validar(telefone.getTipo());
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
