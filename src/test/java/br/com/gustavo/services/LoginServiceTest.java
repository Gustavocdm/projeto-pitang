package br.com.gustavo.services;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.services.protocols.CompararHash;
import br.com.gustavo.services.protocols.FindUserByEmail;

public class LoginServiceTest {
	@InjectMocks
	LoginService sut;
	
	@Mock
	CompararHash compararHash;
	
	@Mock
	FindUserByEmail usuarioRepository;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarFalseSeUsuarioNaoEncontrado() {
		when(usuarioRepository.findByEmail(anyString())).thenReturn(null);
		
		boolean login = sut.logar("email", "senha");
		
		assertFalse(login);
	}
}
