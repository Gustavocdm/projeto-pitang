package br.com.gustavo.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.controllers.validacao.Validacao;
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
	
	@Inject
	private LoginSessao loginSessao;
	
	@Inject
	private Validacao<Usuario> validacao;	
	
	@PostConstruct
	public void setup() {
		addTelefone();
	}
	
	public String cadastrar() {
		try {
			InputInvalidoException validado = validacao.validar(usuario);
			
			if (validado != null) {
				System.out.println(validado.getMessage());
				return "";
			}
			
			usuario = cadastroUsuario.cadastrarUsuario(usuario);
			
			if (usuario != null) {
				loginSessao.logarUsuarioNaSessao(usuario);
				return "/auth/index.xhtml?faces-redirect=true";
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
