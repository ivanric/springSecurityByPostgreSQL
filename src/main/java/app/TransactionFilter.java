package app;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class TransactionFilter implements Filter {//TransactionFilter - para iniciar y confirmar transacciones
//REF: http://www.baeldung.com/spring-boot-add-filter 
 

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("FILTRO 1 INIT...");
		
	}
	   @Override
	    public void doFilter(
	      ServletRequest request, 
	      ServletResponse response, 
	      FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest req = (HttpServletRequest) request;
//	        Principal principal=req.getUserPrincipal();
//	        System.out.println("USUARIO: "+principal.getName());
	        
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String UsuarioAutentificado = authentication.getName();
	        System.out.println(UsuarioAutentificado);
	        
	        System.out.println("Iniciando una transaccion de req : {1} "+req.getRequestURI());
	        chain.doFilter(request, response);
	        System.out.println("Confirmando transaccion de req : {1} "+req.getRequestURI());
	    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
