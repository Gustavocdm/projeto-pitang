package br.com.gustavo.services;

import static br.com.gustavo.builders.UsuarioBuilder.umUsuario;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.services.protocols.CompararHash;
import br.com.gustavo.services.protocols.UsuarioRepository;

public class LoginServiceTest {
	@InjectMocks
	LoginService sut;
	
	@Mock
	CompararHash compararHash;
	
	@Mock
	UsuarioRepository usuarioRepository;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveChamarUsuarioRepositoryComEmailPassado() {
		String email = "email";
		
		sut.logar(email, "senha");
		
		verify(usuarioRepository).findByEmail(email);
	}
	
	@Test
	public void deveRetornarFalseSeUsuarioNaoEncontrado() {
		when(usuarioRepository.findByEmail(anyString())).thenReturn(null);
		
		boolean login = sut.logar("email", "senha");
		
		assertFalse(login);
	}

	
	@Test
	public void deveChamarCompararHashComEmailESenhaPassados() {
		
		Usuario usuario = umUsuario().comSenha("senha_entidade").pegar();
		
		String senha = "senha";
		
		when(usuarioRepository.findByEmail(anyString())).thenReturn(usuario);
		
		sut.logar("email", senha);
		
		verify(compararHash).compararHash(senha, usuario.getSenha());
	}
	
	@Test
	public void deveRetornarFalseSeSenhaNaoBaterComHash() {
		Usuario usuario = umUsuario().pegar();
		
		when(usuarioRepository.findByEmail(anyString())).thenReturn(usuario);
		
		when(compararHash.compararHash(anyString(), anyString())).thenReturn(false);
		
		boolean login = sut.logar("email", "senha");
		
		assertFalse(login);
	}
	
}
