package br.com.gustavo.controllers.validacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class EmailValidacaoTest {
	@Spy
	EmailValidacao sut;
	
	private String emailValido = "email_valido@hotmail.com";
	private String emailInvalido = "email_invalido";
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarNullSeEmailForValido() {
		InputInvalidoException retorno = sut.validar(emailValido);
		assertNull(retorno);		
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionSeEmailInvalido() {
		InputInvalidoException retorno = sut.validar(emailInvalido);
		assertNotNull(retorno);
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorreta() {
		InputInvalidoException retorno = sut.validar(emailInvalido);
		assertEquals("Email inválido.", retorno.getMessage());
	}
}
