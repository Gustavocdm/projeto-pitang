package br.com.gustavo.controllers.exceptions;

public class InputInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InputInvalidoException(String mensagem) {
		super(mensagem);
	}

}
