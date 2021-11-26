package br.com.gustavo.controllers;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.AtualizarEntidade;

public class UpdateControllerTest {

	@InjectMocks
	UpdateController sut;

	@Mock
	LoginSessao loginSessao;

	@Mock
	private AtualizarEntidade<Usuario> atualizarUsuario;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void deveAtualizarOUsuarioLogadoNaSessaoAposUpdate() {
		Usuario usuario = umUsuario().comId(5).pegar();

		when(atualizarUsuario.atualizar(any())).thenReturn(usuario);

		sut.update();

		Mockito.verify(loginSessao).logarUsuarioNaSessao(usuario);
	}

	@Test
	public void deveRetornarUrlDoIndexAposAtualizarUsuario() {
		Usuario usuario = umUsuario().pegar();

		when(atualizarUsuario.atualizar(any())).thenReturn(usuario);

		String url = sut.update();

		assertEquals("/auth/index.xhtml?faces-redirect=true", url);
	}

	@Test
	public void deveRetornarUrlVaziaSeAtualizarUsuarioLancarExcecao() {
		when(atualizarUsuario.atualizar(any())).thenThrow(new RuntimeException());

		String url = sut.update();

		assertEquals("", url);
	}

}
