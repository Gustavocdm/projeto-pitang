package br.com.gustavo.controllers;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.Login;

public class LoginControllerTest {
	
	@InjectMocks
	LoginController sut;
	
	@Mock
	Login login;
	
	@Mock
	LoginSessao loginSessao;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarUrlVaziaSeLoginRetornaNull() {
		when(login.logar(anyString(), anyString())).thenReturn(null);
		
		String url = sut.logar();
		
		assertEquals("", url);
	}
	
	@Test
	public void deveLogarNaSessaoSeLoginFoiBemSucedido() {
		Usuario usuario = umUsuario().comId(3).pegar();
		
		when(login.logar(anyString(), anyString())).thenReturn(usuario);
		
		sut.logar();
		
		verify(loginSessao).logarUsuarioNaSessao(usuario);
	}
	
	@Test
	public void deveRetornarUrlDoIndexSeLoginEfetuadoComSucesso() {
		Usuario usuario = umUsuario().pegar();
		
		when(login.logar(anyString(), anyString())).thenReturn(usuario);
		
		String url = sut.logar();
		
		
		assertEquals("/auth/index.xhtml?faces-redirect=true", url);
	}
	
	@Test
	public void deveRetornarUrlVaziaSeLoginLancarExcecao() {
		when(login.logar(anyString(), anyString())).thenThrow(new RuntimeException());
		
		String url = sut.logar();
		
		assertEquals("", url);
	}
}
