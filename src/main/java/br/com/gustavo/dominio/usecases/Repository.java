package br.com.gustavo.dominio.usecases;

public interface Repository <T> extends EntityCreate<T>, EntityDelete<T>, EntityFindById<T>, EntityList<T>, EntityUpdate<T> {

}
