package br.com.gustavo.controllers.validacao;

import static br.com.gustavo.builders.TelefoneBuilder.umTelefone;
import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.dominio.model.Telefone;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioValidacaoBuilderTest {
	@Spy
	UsuarioValidacaoBuilder sut;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarNullSeUsuarioForValido() {
		Usuario usuario = umUsuario().pegar();
		Telefone telefone = umTelefone().pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertNull(retorno);
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionSeNomeEstiverVazio() {
		Usuario usuario = umUsuario().comNome("").pegar();
		Telefone telefone = umTelefone().pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertNotNull(retorno);
	}
	

	@Test
	public void deveRetornarInputInvalidoExceptionSeSenhaEstiverVazio() {
		Usuario usuario = umUsuario().semSenha().pegar();
		Telefone telefone = umTelefone().pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertNotNull(retorno);
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionSeEmailEstiverVazio() {
		Usuario usuario = umUsuario().comEmail("").pegar();
		Telefone telefone = umTelefone().pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertNotNull(retorno);
	}
	@Test
	public void deveRetornarInputInvalidoExceptionSeAlgumNumeroTelefoneEstiverVazio() {
		Usuario usuario = umUsuario().pegar();
		Telefone telefone = umTelefone().comNumero("").pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertNotNull(retorno);
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorretaSeEmailComFormatoInvalido() {
		Usuario usuario = umUsuario().comEmail("formato_errado").pegar();
		Telefone telefone = umTelefone().pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertEquals("Email inválido.", retorno.getMessage());
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorretaSeDddIncorreto() {
		Integer dddInvalido = -12;
		String mensagemEsperada = dddInvalido + " é um DDD inválido.";
		
		Usuario usuario = umUsuario().pegar();
		
		Telefone telefone = umTelefone().comDdd(dddInvalido).pegar();
		
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertEquals(mensagemEsperada, retorno.getMessage());
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorretaSeNumeroTelefoneIncorreto() {
		String numeroTelefoneInvalido = "90909";
		String mensagemEsperada = numeroTelefoneInvalido + " é um número de telefone inválido.";
		Usuario usuario = umUsuario().pegar();
		Telefone telefone = umTelefone().comNumero(numeroTelefoneInvalido).pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertEquals(mensagemEsperada, retorno.getMessage());
	}
	
	@Test
	public void deveRetornarInputInvalidoExceptionComMensagemCorretaSeTipoTelefoneIncorreto() {
		String tipoTelefoneInvalido = "tipo inválido";
		String mensagemEsperada = tipoTelefoneInvalido + " é um tipo de telefone inválido.";
		Usuario usuario = umUsuario().pegar();
		Telefone telefone = umTelefone().comTipo(tipoTelefoneInvalido).pegar();
		usuario.setTelefones(Arrays.asList(telefone));
		
		InputInvalidoException retorno = sut.validar(usuario);
		
		assertEquals(mensagemEsperada, retorno.getMessage());
	}
}
