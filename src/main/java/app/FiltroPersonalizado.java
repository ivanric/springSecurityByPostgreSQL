package app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Customizer;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


//@Component//SE QUITA EL COMPONENT PARA PODER TENER UN FILTRO PERSONALIZADO Y NO SE APLIQUE EL FILTRO A TODA LA APP
@Order(3)//EL ORDEN MAS ALTO SE EJECUTA PRIMERO
public class FiltroPersonalizado implements Filter {//link:https://www.javadevjournal.com/spring-boot/spring-boot-add-filter/
 
	private  final Logger LOG = LoggerFactory.getLogger(Customizer.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("FILTRO 3 INIT...");
	}
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String UsuarioAutentificado = authentication.getName();
        if(!UsuarioAutentificado.equals("anonymousUser")) {
          
          System.out.println(UsuarioAutentificado);     
          //LOG.info("Logging Request  {2} : {}", req.getMethod(),req.getRequestURI());
          System.out.println("Solicitud de registro : {3} "+req.getMethod()+" "+req.getRequestURI());
          chain.doFilter(request, response);
          //LOG.info("Logging Response :{2}",res.getContentType());
          System.out.println("Respuesta de registro : {3} "+res.getContentType());
        }else {
            response.reset();
    		response.getWriter().println("Error en la autentiación: token no presente");
    		response.getWriter().flush();
        }
    }

	@Override
	public void destroy() {
	}
 
}