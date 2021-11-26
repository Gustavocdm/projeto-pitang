package br.com.gustavo.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.AtualizarEntidade;

@Named
@ViewScoped
public class UpdateController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	LoginSessao loginSessao;
	
	@Inject
	private AtualizarEntidade<Usuario> atualizarUsuario;
	
	@Inject
	private Usuario usuario;
	
	@PostConstruct
	public void setup() {
		copiarUsuarioDoLoginSessao();
	}
	
	public String update() {
		try {
			Usuario usuarioAtualizado = atualizarUsuario.atualizar(usuario);
			loginSessao.logarUsuarioNaSessao(usuarioAtualizado);
			return "/auth/index.xhtml?faces-redirect=true";
		}
		catch (Exception e) {
			return "";
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	private void copiarUsuarioDoLoginSessao() {
		usuario.setId(loginSessao.getUsuarioLogado().getId());
		usuario.setNome(loginSessao.getUsuarioLogado().getNome());
		usuario.setEmail(loginSessao.getUsuarioLogado().getEmail());

		for (Telefone telefone : loginSessao.getUsuarioLogado().getTelefones()) {
			Telefone t = new Telefone();
			t.setId(telefone.getId());
			t.setDdd(telefone.getDdd());
			t.setNumero(telefone.getNumero());
			t.setTipo(telefone.getTipo());
			
			usuario.getTelefones().add(t);
		}
	}
	
	public void addTelefone() {
		usuario.getTelefones().add(new Telefone());
	}
	
	public void removeTelefone(int index) {
		usuario.getTelefones().remove(index);
	}
}
