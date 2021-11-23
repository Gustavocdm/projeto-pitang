package br.com.gustavo.dominio.usecases;

public interface EntityFindById <T> {
	public T findById(Integer id);
}
