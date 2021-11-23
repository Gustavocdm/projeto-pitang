package br.com.gustavo.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;

@Named
@ViewScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Telefone telefone;

	@PostConstruct
	public void Teste() {
		System.out.println("Testando persistência");

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pitang");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario(); usuario.setNome("Gustavo");
		usuario.setEmail("email_pessoal@hotmail.com");
		usuario.setSenha("senha12345");
		
		em.getTransaction().begin();
		System.out.println("Finalizou operacão");
		
		em.persist(usuario);
		em.flush();		
		
		Telefone telefone1 = new Telefone();
		Telefone telefone2 = new Telefone();
		
		telefone1.setDdd(81);
		telefone1.setNumero("998450718");
		telefone1.setTipo("celular");
		telefone1.setUsuario(usuario);
		
		telefone2.setDdd(81);
		telefone2.setNumero("32715463");
		telefone2.setTipo("fixo");
		telefone2.setUsuario(usuario);
		
		em.persist(telefone1);
		em.persist(telefone2);
		
		
		em.getTransaction().commit();
		
		this.usuario = em.find(Usuario.class, 1);
		this.telefone= em.find(Telefone.class, 2);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
