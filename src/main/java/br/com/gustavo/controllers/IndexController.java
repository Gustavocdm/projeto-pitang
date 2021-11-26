package br.com.gustavo.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.DeletarEntidade;
import br.com.gustavo.dominio.usecases.ListarEntidades;

@Named
@ViewScoped
public class IndexController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ListarEntidades<Usuario> listarUsuarios;
	
	@Inject DeletarEntidade<Usuario> deletarUsuario;
	
	@Inject
	LoginSessao loginSessao;
	
	private List<Usuario> usuarios;
	
	
	@PostConstruct
	public void setup() {
		usuarios = listarUsuarios.listar();
	}

	public String deletarUsuario() {
		deletarUsuario.deletar(loginSessao.getUsuarioLogado());
		return loginSessao.deslogarUsuarioDaSessao();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
