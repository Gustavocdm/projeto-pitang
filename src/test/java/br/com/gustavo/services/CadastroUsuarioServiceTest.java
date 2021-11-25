package br.com.gustavo.services;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.services.protocols.Hasher;
import br.com.gustavo.services.protocols.UsuarioRepository;

public class CadastroUsuarioServiceTest {
	
	@InjectMocks
	CadastroUsuarioService sut;
	
	@Mock
	Hasher hasher;
	
	@Mock
	UsuarioRepository usuarioRepository;
	
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveChamarHashComASenhaPassada() {
		Usuario usuario = umUsuario().comSenha("senha").pegar();

		String senha = usuario.getSenha();
		
		sut.cadastrarUsuario(usuario);

		verify(hasher).hash(senha);
	}
	
	@Test
	public void deveSetarHashNaSenhaDoUsuario() {
		 when(hasher.hash(anyString())).thenReturn("hash");
		
		Usuario usuario = umUsuario().pegar();
		
		sut.cadastrarUsuario(usuario);
		
		assertEquals("hash", usuario.getSenha());
	}
	
	@Test
	public void deveChamarRepositoryComOUsuarioPassado() {
		Usuario usuario = umUsuario().comId(4).pegar();
		
		sut.cadastrarUsuario(usuario);

		verify(usuarioRepository).create(usuario);
	}
	
	@Test
	public void deveRetornarOUsuarioCriadoPeloRepository() {
		Usuario usuarioPassadoNoSut = umUsuario().comId(10).pegar();
		
		Usuario usuarioRetornoRepository = umUsuario().comId(5).pegar();
		
		when(usuarioRepository.create(any())).thenReturn(usuarioRetornoRepository);
		
		Usuario usuarioRetornadoPeloSut = sut.cadastrarUsuario(usuarioPassadoNoSut);
		
		assertEquals(usuarioRetornoRepository, usuarioRetornadoPeloSut);
	}
	
	@Test
	public void deveLancarExcecaoSeEntityCreateLancarExcecao() {
		Usuario usuario = umUsuario().pegar();
		
		when(usuarioRepository.create(any())).thenThrow(new RuntimeException("mensagem"));
		
		try {
			sut.cadastrarUsuario(usuario);
			Assert.fail();
		}
		catch (RuntimeException e) {
			assertTrue(true);
		}
	}
	
}
