package br.com.rhonline.multitenant;

import static br.com.rhonline.multitenant.MultiTenantConstants.CURRENT_TENANT_IDENTIFIER;
import static br.com.rhonline.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

	@Override
	public String resolveCurrentTenantIdentifier() {
		
		if( SecurityContextHolder.getContext().getAuthentication() == null || SecurityContextHolder.getContext().getAuthentication().getPrincipal()==null){
			return DEFAULT_TENANT_ID;
		}
		
		if( "anonymousUser".equalsIgnoreCase(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())){
			return DEFAULT_TENANT_ID;
		}
		
		
//		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//		if (requestAttributes != null) {
//			String tenantId = (String) requestAttributes.getAttribute(CURRENT_TENANT_IDENTIFIER, RequestAttributes.SCOPE_REQUEST);
//			if (tenantId != null) {
//				return tenantId;
//			}
//		}
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public void forceCurrentTenantIndetifier(String tenant) {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null) {
			requestAttributes.setAttribute(CURRENT_TENANT_IDENTIFIER, tenant, RequestAttributes.SCOPE_REQUEST);
		}
	}

	@Override
	public boolean validateExistingCurrentSessions() {		
		return true;
	}

}
