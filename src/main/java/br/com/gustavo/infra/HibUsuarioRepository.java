package br.com.gustavo.infra;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.services.protocols.UsuarioRepository;

@RequestScoped
public class HibUsuarioRepository implements UsuarioRepository, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;

	@Override
	public Usuario create(Usuario entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void delete(Usuario entity) {
		em.getTransaction().begin();
		em.remove(findById(entity.getId()));
		em.getTransaction().commit();		
	}

	@Override
	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> list() {
		String query = "select c from Usuario c";
		TypedQuery<Usuario> typedQuery = em.createQuery(query, Usuario.class);
		return typedQuery.getResultList();
	}

	@Override
	public Usuario update(Usuario entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public Usuario findByEmail(String email) {
		String query = "select c from Usuario c where email = :email";
		TypedQuery<Usuario> typedQuery = em.createQuery(query, Usuario.class).setParameter("email", email);
		return typedQuery.getSingleResult();
	}

}
