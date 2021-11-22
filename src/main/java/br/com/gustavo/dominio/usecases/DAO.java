package br.com.gustavo.dominio.usecases;

import java.util.List;

public interface DAO<T> {
	public T create(T entity);
	
	public T update(T entity);
	
	public T findById(Integer id);
	
	public List<T> list();
}
