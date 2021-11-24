package br.com.gustavo.services;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

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
		 when(sut.hasher.hash(anyString())).thenReturn("hash");
		
		Usuario usuario = umUsuario().pegar();
		
		sut.create(usuario);
		
		assertEquals("hash", usuario.getSenha());
	}
	
	
}
