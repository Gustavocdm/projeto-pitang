package br.com.gustavo.controllers;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.CadastroUsuario;

public class CadastroControllerTest {
	
	@InjectMocks
	CadastroController sut;
	
	@Mock
	CadastroUsuario cadastroUsuario;
	
	@Mock
	LoginSessao loginSessao;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarUrlVaziaSeCadastroUsuarioLancarExcecao() {
		when(cadastroUsuario.cadastrarUsuario(any())).thenThrow(new RuntimeException("any_message"));
		
		String url = sut.cadastrar();
		
		assertEquals("", url);		
	}
	
	@Test
	public void deveLogarNaSessaoComUsuarioCriado() {
		Usuario usuario = umUsuario().comId(3).pegar();
		
		when(cadastroUsuario.cadastrarUsuario(any())).thenReturn(usuario);
		
		sut.cadastrar();
		
		verify(loginSessao).logarUsuarioNaSessao(usuario);
	}
	
	@Test
	public void deveRedirecionarParaOIndexSeUsuarioCadastradoComSucesso() {
		when(cadastroUsuario.cadastrarUsuario(any())).thenReturn(new Usuario());
		
		String url = sut.cadastrar();
		
		assertEquals("/auth/index.xhtml?faces-redirect=true", url);
	}
	
}
