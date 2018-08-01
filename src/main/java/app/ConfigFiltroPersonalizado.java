package app;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConfigFiltroPersonalizado {
	@Bean
	public FilterRegistrationBean<FiltroPersonalizado> loggingFilter(){
	    FilterRegistrationBean<FiltroPersonalizado> registrationBean= new FilterRegistrationBean<>();
     
	    registrationBean.setFilter(new FiltroPersonalizado());
	    registrationBean.addUrlPatterns("/Personalizado/*");
//	    registrationBean.addUrlPatterns("/demo/*");
	    registrationBean.setOrder(2); //set precedence
	    return registrationBean;      
	}
}
