package br.com.gustavo.dominio.usecases;

import java.util.List;

public interface ListarEntidades <T> {
	public List<T> listar();
}
