package br.com.gustavo.services;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.Login;
import br.com.gustavo.services.protocols.CompararHash;
import br.com.gustavo.services.protocols.UsuarioRepository;

@Dependent
public class LoginService implements Login, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CompararHash compararHash;
	
	@Inject
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario logar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) {
			return null;
		}
		
		if (! compararHash.compararHash(senha, usuario.getSenha())) {
			return null;
		}
		
		return usuario;
	}

}
