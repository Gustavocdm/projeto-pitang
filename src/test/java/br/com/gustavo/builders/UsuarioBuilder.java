package br.com.gustavo.builders;

import java.util.ArrayList;

import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioBuilder {
	private Usuario usuario;
	
	private UsuarioBuilder() {}
	
	public static UsuarioBuilder umUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		builder.usuario = new Usuario();
		builder.usuario.setNome("nome");
		builder.usuario.setEmail("email");
		builder.usuario.setSenha("senha");
		builder.usuario.setTelefones(new ArrayList<Telefone>());
		return builder;
	}
	
	public Usuario pegar() {
		return usuario;
	}
}