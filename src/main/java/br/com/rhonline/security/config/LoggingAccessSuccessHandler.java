package br.com.rhonline.security.config;

import static br.com.rhonline.multitenant.MultiTenantConstants.CURRENT_TENANT_IDENTIFIER;
import static br.com.rhonline.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoggingAccessSuccessHandler implements AuthenticationSuccessHandler {

	private static Logger log = LoggerFactory.getLogger(LoggingAccessDeniedHandler.class);
	
	RedirectStrategy redirect = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth)
			throws IOException, ServletException {

		log.debug("Usuário autenticado com sucesso: " + auth.getName());

		if (auth.getName() == null || auth.getName() == "anonymousUser") {
			req.setAttribute(CURRENT_TENANT_IDENTIFIER, DEFAULT_TENANT_ID);
		} else {
			req.setAttribute(CURRENT_TENANT_IDENTIFIER, auth.getName());
		}
		
		redirect.sendRedirect(req, resp, "/empresa/listacolaboradores");
	}
}
