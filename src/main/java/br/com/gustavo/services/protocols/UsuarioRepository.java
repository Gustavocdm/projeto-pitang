package br.com.gustavo.services.protocols;

import br.com.gustavo.dominio.model.Usuario;

public interface UsuarioRepository extends Repository<Usuario> {
	public Usuario findByEmail(String email);
}
