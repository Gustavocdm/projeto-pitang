package br.com.gustavo.controllers.validacao;

import javax.enterprise.context.RequestScoped;

import br.com.gustavo.controllers.exceptions.InputInvalidoException;
import br.com.gustavo.controllers.validacao.usuario.CadastroUsuarioValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioComEmailValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioComNomeValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioComSenhaValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioDddValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioEmailFormatoValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioNumeroTelefoneNaoVazioValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioNumeroTelefoneValidacao;
import br.com.gustavo.controllers.validacao.usuario.UsuarioTipoTelefoneValidacao;
import br.com.gustavo.dominio.model.Usuario;

@RequestScoped
public class UsuarioValidacaoBuilder implements Validacao<Usuario> {
		
	@Override
	public InputInvalidoException validar(Usuario input) {
		
		CadastroUsuarioValidacao comNome = new UsuarioComNomeValidacao();
		CadastroUsuarioValidacao comEmail = new UsuarioComEmailValidacao();
		CadastroUsuarioValidacao comSenha= new UsuarioComSenhaValidacao();
		CadastroUsuarioValidacao comEmailFormato= new UsuarioEmailFormatoValidacao();
		CadastroUsuarioValidacao comDddsCorreto = new UsuarioDddValidacao();
		CadastroUsuarioValidacao comTelefones = new UsuarioNumeroTelefoneNaoVazioValidacao();
		CadastroUsuarioValidacao comNumerosTelefoneCorreto = new UsuarioNumeroTelefoneValidacao();
		CadastroUsuarioValidacao comTiposTelefoneCorreto = new UsuarioTipoTelefoneValidacao();
		
		
		comNome.setarProximaValidacao(comEmail);
		comEmail.setarProximaValidacao(comSenha);
		comSenha.setarProximaValidacao(comEmailFormato);
		comEmailFormato.setarProximaValidacao(comDddsCorreto);
		comDddsCorreto.setarProximaValidacao(comTelefones);
		comTelefones.setarProximaValidacao(comNumerosTelefoneCorreto);
		comNumerosTelefoneCorreto.setarProximaValidacao(comTiposTelefoneCorreto);
		
		return comNome.validar(input);
		
	}

}
