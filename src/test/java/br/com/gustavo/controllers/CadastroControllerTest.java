package br.com.gustavo.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gustavo.dominio.usecases.CadastroUsuario;

public class CadastroControllerTest {
	
	@InjectMocks
	CadastroController sut;
	
	@Mock
	CadastroUsuario cadastroUsuario;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarStringVaziaSeCadastroUsuarioLancarExcecao() {
		when(cadastroUsuario.cadastrarUsuario(any())).thenThrow(new RuntimeException("any_message"));
		
		String url = sut.cadastrar();
		
		assertEquals("", url);		
	}
	
}
