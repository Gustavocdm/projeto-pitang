package br.com.gustavo.services;

import javax.inject.Inject;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.Login;
import br.com.gustavo.services.protocols.CompararHash;
import br.com.gustavo.services.protocols.FindUserByEmail;

public class LoginService implements Login {
	
	private CompararHash compararHash;
	private FindUserByEmail usuarioRepository;
	
	@Inject
	public LoginService(CompararHash compararHash, FindUserByEmail usuarioRepository) {
		this.compararHash = compararHash;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public boolean logar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) {
			return false;
		}
		return true;
	}

}
