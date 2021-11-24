package br.com.gustavo.services.protocols;

import br.com.gustavo.dominio.model.Usuario;

public interface FindUserByEmail {
	public Usuario findByEmail(String email);
}
