package br.com.gustavo.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.CadastroUsuario;

@Named
@ViewScoped
public class CadastroController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;
	
	@Inject
	private CadastroUsuario cadastroUsuario;
	
	
	@PostConstruct
	public void setup() {
		addTelefone();
	}
	
	public String cadastrar() {
		try {
			usuario = cadastroUsuario.cadastrarUsuario(usuario);
			
			if (usuario != null) {
				return "login?faces-redirect=true";
			}
		}
		catch(Exception e) {
			return "";
		}
		
		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void addTelefone() {
		usuario.getTelefones().add(new Telefone());
	}
	
	public void removeTelefone(int index) {
		usuario.getTelefones().remove(index);
	}
}
