package br.com.gustavo.model;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
	private String nome;
	private String email;
	private String senha;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void addTelefone(Telefone telefone) {
		telefones.add(telefone);
	}
}
