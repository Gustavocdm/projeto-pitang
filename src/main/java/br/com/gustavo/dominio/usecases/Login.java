package br.com.gustavo.dominio.usecases;

import br.com.gustavo.dominio.model.Usuario;

public interface Login {
	public Usuario logar(String email, String senha);
}
