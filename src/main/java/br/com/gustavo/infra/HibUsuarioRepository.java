package br.com.gustavo.infra;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.services.protocols.UsuarioRepository;

public class HibUsuarioRepository implements UsuarioRepository {
	
	EntityManager em;

	@Override
	public Usuario create(Usuario entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
