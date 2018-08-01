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
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {//LINK--> http://www.baeldung.com/spring-boot-add-filter
	private  final Logger LOG = LoggerFactory.getLogger(Customizer.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("FILTRO 2 INIT...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        System.out.println("FILTRO 2 doFilter");
	        LOG.info(
	          "Logging Request  {} : {}", req.getMethod(), 
	          req.getRequestURI());
	        chain.doFilter(request, response);
	        LOG.info(
	          "Logging Response :{}", 
	          res.getContentType());
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
    // other methods
}
