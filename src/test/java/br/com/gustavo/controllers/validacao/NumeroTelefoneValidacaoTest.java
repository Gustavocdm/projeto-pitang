package br.com.gustavo.controllers.validacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class NumeroTelefoneValidacaoTest {
	@Spy
	NumeroTelefoneValidacao sut;
	
	private String numeroTelefoneValido = "998450718";
	private String numeroTelefoneInvalido = "95852";
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarNullSeEmailForValido() {
		InputInvalidoException retorno = sut.validar(numeroTelefoneValido);
		assertNull(retorno);		
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionSeEmailInvalido() {
		InputInvalidoException retorno = sut.validar(numeroTelefoneInvalido);
		assertNotNull(retorno);
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorreta() {
		String mensagemEsperada = numeroTelefoneInvalido + " é um número de telefone inválido.";
		InputInvalidoException retorno = sut.validar(numeroTelefoneInvalido);
		assertEquals(mensagemEsperada, retorno.getMessage());
	}
}
