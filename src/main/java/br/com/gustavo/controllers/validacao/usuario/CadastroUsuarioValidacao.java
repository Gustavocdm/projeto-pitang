package br.com.gustavo.controllers.validacao.usuario;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.Validacao;
import br.com.gustavo.dominio.model.Usuario;

public abstract class CadastroUsuarioValidacao<T> implements Validacao<Usuario> {
	protected CadastroUsuarioValidacao proximaValidacao;
	
	Validacao<T> validacaoNecessaria;
	
	protected CadastroUsuarioValidacao(Validacao<T> validacaoNecessaria) {
		this.validacaoNecessaria = validacaoNecessaria;
	}
	
	@Override
	public abstract InputInvalidoException validar(Usuario input);
	
	
	public void setarProximaValidacao(CadastroUsuarioValidacao proximaValidacao) {
		this.proximaValidacao = proximaValidacao;
	}
}
