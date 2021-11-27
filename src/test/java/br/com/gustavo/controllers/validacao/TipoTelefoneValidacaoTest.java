package br.com.gustavo.controllers.validacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;

public class TipoTelefoneValidacaoTest {
	@Spy
	TipoTelefoneValidacao sut;
	
	private String tipoTelefoneValido = "celular";
	private String tipoTelefoneInvalido = "invalido";
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarNullSeTipoTelefoneForValido() {
		InputInvalidoException retorno = sut.validar(tipoTelefoneValido);
		assertNull(retorno);		
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionSeTipoTelefoneInvalido() {
		InputInvalidoException retorno = sut.validar(tipoTelefoneInvalido);
		assertNotNull(retorno);
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorreta() {
		String mensagemEsperada = tipoTelefoneInvalido + " é um tipo de telefone inválido.";
		InputInvalidoException retorno = sut.validar(tipoTelefoneInvalido);
		assertEquals(mensagemEsperada, retorno.getMessage());
	}
}
