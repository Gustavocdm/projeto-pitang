package br.com.gustavo.controllers.sessao;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.gustavo.dominio.model.Usuario;

@Named
@SessionScoped
public class LoginSessao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuarioLogado = null;
	
	public void logarUsuarioNaSessao(Usuario usuario) {
		usuarioLogado = usuario;
	}
	
	public String deslogarUsuarioDaSessao() {
		usuarioLogado = null;
		return "/login.xhtml";
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}	
}
