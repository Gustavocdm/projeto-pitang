package br.com.gustavo.builders;

import java.util.ArrayList;
import java.util.List;

import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioBuilder {
	private Usuario usuario;
	
	private UsuarioBuilder() {}
	
	public static UsuarioBuilder umUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		builder.usuario = new Usuario();
		builder.usuario.setId(1);
		builder.usuario.setNome("nome");
		builder.usuario.setEmail("email_correto@hotmail.com");
		builder.usuario.setSenha("senha");
		builder.usuario.setTelefones(new ArrayList<Telefone>());
		return builder;
	}
	
	public UsuarioBuilder comId(Integer id) {
		usuario.setId(id);
		return this;
	}
	
	public UsuarioBuilder comSenha(String senha) {
		usuario.setSenha(senha);
		return this;
	}
	
	public UsuarioBuilder comTelefones(List<Telefone> telefones) {
		usuario.setTelefones(telefones);
		return this;
	}
	
	public UsuarioBuilder semSenha() {
		usuario.setSenha("");
		return this;
	}
	
	public UsuarioBuilder comNome(String nome) {
		usuario.setNome(nome);
		return this;
	}
	
	public UsuarioBuilder comEmail(String email) {
		usuario.setEmail(email);
		return this;
	}
	
	public Usuario pegar() {
		return usuario;
	}
}
