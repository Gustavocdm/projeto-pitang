package br.com.gustavo.controllers.validacao;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class DddValidacaoTest {
	@Mock
	DddValidacao sut;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void deveRetornarNullSeDddPassadoForValido() {
		sut.validar(14);
	}
}
