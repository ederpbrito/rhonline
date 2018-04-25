package br.com.rhonline.multitenant;

import static br.com.rhonline.multitenant.MultiTenantConstants.CURRENT_TENANT_IDENTIFIER;
import static br.com.rhonline.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MultiTenantFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
 		HttpServletRequest req = (HttpServletRequest) servletRequest; 		
 		
 		String tenantid = (String) req.getAttribute(CURRENT_TENANT_IDENTIFIER);
 		
		if (tenantid != null) {
			req.setAttribute(CURRENT_TENANT_IDENTIFIER, tenantid);
		} else {
			req.setAttribute(CURRENT_TENANT_IDENTIFIER, DEFAULT_TENANT_ID);
		}
		
		filterChain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void destroy() {
	}
}
