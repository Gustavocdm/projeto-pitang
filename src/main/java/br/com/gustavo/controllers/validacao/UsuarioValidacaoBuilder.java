package br.com.gustavo.controllers.validacao;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.usuario.CadastroUsuarioValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioComEmailValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioComNomeValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioComSenhaValidacao;
import br.com.gustavo.dominio.model.Usuario;

public class UsuarioValidacaoBuilder implements Validacao<Usuario> {
		
	@Override
	public InputInvalidoException validar(Usuario input) {
		
		CadastroUsuarioValidacao comNome = new UsuarioComNomeValidacao();
		CadastroUsuarioValidacao comEmail = new UsuarioComEmailValidacao();
		CadastroUsuarioValidacao comSenha= new UsuarioComSenhaValidacao();
		CadastroUsuarioValidacao comEmailFormato= new UsuarioComNomeValidacao();
		CadastroUsuarioValidacao comDddsCorreto = new UsuarioComNomeValidacao();
		CadastroUsuarioValidacao comNumerosTelefoneCorreto = new UsuarioComNomeValidacao();
		CadastroUsuarioValidacao comTiposTelefoneCorreto = new UsuarioComNomeValidacao();
		
		
		comNome.setarProximaValidacao(comEmail);
		comEmail.setarProximaValidacao(comSenha);
		comSenha.setarProximaValidacao(comEmailFormato);
		comEmailFormato.setarProximaValidacao(comDddsCorreto);
		comDddsCorreto.setarProximaValidacao(comNumerosTelefoneCorreto);
		comNumerosTelefoneCorreto.setarProximaValidacao(comTiposTelefoneCorreto);
		
		return comNome.validar(input);
		
	}

}
