package br.com.gustavo.controllers;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.Login;

@Named
@ViewScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	
	@Inject
	Login login;
	
	@Inject
	private LoginSessao loginSessao;
	
	public String logar() {
		try {
			Usuario usuario = login.logar(email, senha);
			if (usuario != null) {
				loginSessao.logarUsuarioNaSessao(usuario);
				return "/auth/index.xhtml?faces-redirect=true";
			}
			else {
				return "";				
			}
		}
		catch(Exception e) {
			return "";
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
