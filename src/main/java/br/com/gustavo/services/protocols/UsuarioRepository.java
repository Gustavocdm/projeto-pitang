package br.com.gustavo.services.protocols;

import br.com.gustavo.dominio.model.Usuario;
import br.com.gustavo.dominio.usecases.Repository;

public interface UsuarioRepository extends Repository<Usuario>, FindUserByEmail {

}
