package br.com.gustavo.controllers;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.controllers.sessao.LoginSessao;
import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.DeletarEntidade;
import br.com.gustavo.dominio.usecases.ListarEntidades;

public class IndexControllerTest {
	
	@InjectMocks
	IndexController sut;
	
	@Mock
	private ListarEntidades<Usuario> listarUsuarios;
	
	@Mock DeletarEntidade<Usuario> deletarUsuario;
	
	@Mock
	LoginSessao loginSessao;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	
	@Test
	public void deveDeletarOUsuarioQueEstaLogadoNaSessao() {
		Usuario usuario = umUsuario().comId(5).pegar();
		
		when(loginSessao.getUsuarioLogado()).thenReturn(usuario);
		
		sut.deletarUsuario();
		
		verify(deletarUsuario).deletar(usuario);
	}
	
	@Test
	public void deveDeslogarUsuarioAposDeletar() {
		sut.deletarUsuario();
		verify(loginSessao, times(1)).deslogarUsuarioDaSessao();
	}
}
