package br.com.gustavo.services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.CadastroUsuario;
import br.com.gustavo.dominio.usecases.ListarEntidades;
import br.com.gustavo.services.protocols.Hasher;
import br.com.gustavo.services.protocols.UsuarioRepository;

@Dependent
public class UsuarioService implements CadastroUsuario, ListarEntidades<Usuario>, Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Hasher hasher;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario cadastrarUsuario(Usuario entity) {
		String senhaHash = hasher.hash(entity.getSenha());
		entity.setSenha(senhaHash);
		
		Usuario usuario = usuarioRepository.create(entity);
		
		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		return usuarioRepository.list();
	}
	
	
} 
