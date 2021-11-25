package br.com.gustavo.services;

import javax.inject.Inject;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.Login;
import br.com.gustavo.services.protocols.CompararHash;
import br.com.gustavo.services.protocols.UsuarioRepository;

public class LoginService implements Login {
	
	@Inject
	private CompararHash compararHash;
	
	@Inject
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean logar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) {
			return false;
		}
		
		if (! compararHash.compararHash(senha, usuario.getSenha())) {
			return false;
		}
		
		return true;
	}

}
