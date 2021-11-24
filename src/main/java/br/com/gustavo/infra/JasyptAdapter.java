package br.com.gustavo.infra;

import javax.inject.Inject;

import org.jasypt.util.password.BasicPasswordEncryptor;

import br.com.gustavo.services.protocols.CompararHash;
import br.com.gustavo.services.protocols.Hasher;

public class JasyptAdapter implements Hasher, CompararHash {

	@Inject
	BasicPasswordEncryptor passwordEncryptor;
	
	@Override
	public boolean compararHash(String valor, String hash) {
		return passwordEncryptor.checkPassword(valor, hash);
	}

	@Override
	public String hash(String valor) {
		return passwordEncryptor.encryptPassword(valor);
	}

}
