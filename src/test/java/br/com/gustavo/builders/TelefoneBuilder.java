package br.com.gustavo.builders;

import br.com.gustavo.dominio.model.Telefone;

public class TelefoneBuilder {
	private Telefone telefone;

	private TelefoneBuilder() {}

	public static TelefoneBuilder umTelefone() {
		TelefoneBuilder builder = new TelefoneBuilder();
		builder.telefone = new Telefone();
		builder.telefone.setId(1);
		builder.telefone.setDdd(81);
		builder.telefone.setNumero("998450754");		
		builder.telefone.setTipo("celular");
		return builder;
	}
	
	public TelefoneBuilder comDdd(Integer ddd) {
		telefone.setDdd(ddd);
		return this;
	}
	
	public TelefoneBuilder comNumero(String numero) {
		telefone.setNumero(numero);
		return this;
	}
	
	public TelefoneBuilder comTipo(String tipo) {
		telefone.setTipo(tipo);
		return this;
	}

	public Telefone pegar() {
		return telefone;
	}
}
