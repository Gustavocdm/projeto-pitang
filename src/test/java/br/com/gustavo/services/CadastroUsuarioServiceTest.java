package br.com.gustavo.services;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.EntityCreate;
import br.com.gustavo.services.protocols.Hasher;

public class CadastroUsuarioServiceTest {
	
	@InjectMocks
	CadastroUsuarioService sut;
	
	@Mock
	Hasher hasher;
	
	@Mock
	EntityCreate<Usuario> createRepository;
	
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveSetarHashNaSenhaDoUsuario() {
		 when(hasher.hash(anyString())).thenReturn("hash");
		
		Usuario usuario = umUsuario().pegar();
		
		sut.create(usuario);
		
		assertEquals("hash", usuario.getSenha());
	}
	
	@Test
	public void deveChamarHasherComASenhaCorretaDoUsuario() {
		
	}
	
	@Test
	public void deveRetornarOUsuarioCriadoPeloRepository() {
		Usuario usuarioPassadoNoSut = umUsuario().comId(10).pegar();
		
		Usuario usuarioRetornoRepository = umUsuario().comId(5).pegar();
		
		when(createRepository.create(any())).thenReturn(usuarioRetornoRepository);
		
		Usuario usuarioRetornadoPeloSut = sut.create(usuarioPassadoNoSut);
		
		assertEquals(usuarioRetornoRepository, usuarioRetornadoPeloSut);
	}
	
}
