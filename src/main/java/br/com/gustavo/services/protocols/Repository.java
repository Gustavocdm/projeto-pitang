package br.com.gustavo.services.protocols;

import java.util.List;

public interface Repository <T> {
	public T create(T entity);

	public void delete(T entity);

	public T findById(Integer id);
	
	public List<T> list();
	
	public T update(T entity);
}
