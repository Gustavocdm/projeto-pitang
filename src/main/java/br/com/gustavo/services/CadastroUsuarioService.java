package br.com.gustavo.services;

import javax.inject.Inject;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.EntityCreate;
import br.com.gustavo.services.protocols.Hasher;

public class CadastroUsuarioService implements EntityCreate<Usuario> {
	
	Hasher hasher;
	EntityCreate<Usuario> createRepository;
	
	@Inject
	public CadastroUsuarioService(Hasher hasher, EntityCreate<Usuario> createRepository) {
		this.hasher = hasher;
		this.createRepository = createRepository;
	}
	
	@Inject 

	@Override
	public Usuario create(Usuario entity) {
		String senhaHash = hasher.hash(entity.getSenha());
		entity.setSenha(senhaHash);
		
		Usuario usuario = createRepository.create(entity);
		
		return usuario;
	}
	
	
}
