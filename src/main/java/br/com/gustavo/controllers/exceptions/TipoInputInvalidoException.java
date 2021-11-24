package br.com.gustavo.controllers.exceptions;

public class TipoInputInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public TipoInputInvalidoException(String mensagem) {
		super(mensagem);
	}

}
