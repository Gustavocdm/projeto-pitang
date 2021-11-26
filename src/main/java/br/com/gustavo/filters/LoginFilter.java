package br.com.gustavo.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gustavo.controllers.sessao.LoginSessao;

public class LoginFilter implements Filter {
	
	@Inject
	private LoginSessao loginSessao;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getRequestURL().toString();
		
		if(url.contains("/h2")) {
			chain.doFilter(request, response);
		}
		else if (url.contains("/auth") && loginSessao.getUsuarioLogado() == null) {
			res.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
		}
		else if ((!url.contains("/auth")) && loginSessao.getUsuarioLogado() != null) {
			res.sendRedirect(req.getServletContext().getContextPath() + "/auth/index.xhtml");
		}
		else {
			chain.doFilter(request, response);
		}
	}
	
}
