package br.com.gustavo.services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.AtualizarEntidade;
import br.com.gustavo.dominio.usecases.CadastroUsuario;
import br.com.gustavo.dominio.usecases.DeletarEntidade;
import br.com.gustavo.dominio.usecases.ListarEntidades;
import br.com.gustavo.services.protocols.Hasher;
import br.com.gustavo.services.protocols.UsuarioRepository;

@Dependent
public class UsuarioService implements CadastroUsuario, ListarEntidades<Usuario>, DeletarEntidade<Usuario>, AtualizarEntidade<Usuario>, Serializable {
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

	@Override
	public void deletar(Usuario entidade) {
		usuarioRepository.delete(entidade);
	}

	@Override
	public Usuario atualizar(Usuario entity) {
		if (entity.getSenha().length() > 0) {
			String senhaHash = hasher.hash(entity.getSenha());
			entity.setSenha(senhaHash);
		}
		else {
			Usuario usuarioCadastrado = usuarioRepository.findById(entity.getId());
			entity.setSenha(usuarioCadastrado.getSenha());
		}
		Usuario usuario = usuarioRepository.update(entity);
		return usuario;
	}
	
	
} 
