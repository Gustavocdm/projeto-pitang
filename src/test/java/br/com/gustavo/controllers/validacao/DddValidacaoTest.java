package br.com.gustavo.controllers.validacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class DddValidacaoTest {
	@Spy
	DddValidacao sut;
	
	private Integer dddValido = 15;
	private Integer dddInvalido = -1;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarNullSeDddForValido() {
		InputInvalidoException retorno = sut.validar(dddValido);
		assertNull(retorno);		
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionSeDddInvalido() {
		InputInvalidoException retorno = sut.validar(dddInvalido);
		assertNotNull(retorno);
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorreta() {
		String mensagemEsperada = dddInvalido + " é um DDD inválido.";
		
		InputInvalidoException retorno = sut.validar(dddInvalido);
		
		assertEquals(mensagemEsperada, retorno.getMessage());
	}
}
