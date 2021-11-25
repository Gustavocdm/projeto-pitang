package br.com.gustavo.infra;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import org.jasypt.util.password.BasicPasswordEncryptor;

import br.com.gustavo.services.protocols.CompararHash;
import br.com.gustavo.services.protocols.Hasher;

@RequestScoped
public class JasyptAdapter implements Hasher, CompararHash, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean compararHash(String valor, String hash) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.checkPassword(valor, hash);
	}

	@Override
	public String hash(String valor) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.encryptPassword(valor);
	}

}
