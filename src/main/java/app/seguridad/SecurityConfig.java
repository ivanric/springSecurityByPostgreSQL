package app.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	UserDetailsService userDetailsService;//Interfaz donde se modificara a los Usuarios
	
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {//COMO CONFIGURAR A LOS USUARIOS
//		auth.inMemoryAuthentication().
//		withUser("admin").password("{noop}123").roles("ADMIN","SECRETARIO").and().
////		withUser("pedro").password("123").roles("SECRETARIO").and().passwordEncoder(passwordEncoder());
//		withUser("pedro").password("{noop}123").roles("SECRETARIO");
//		
//	}
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {//COMO CONFIGURAR A LOS USUARIOS
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception { //HttpSecurity http CONFIGURAR LA SEGURIDAD DE LOS RECURSOS
		http
		.csrf().disable()//desactiva  los ataques csrf, osea el form no enviara un token de seguridad  REF: https://docs.spring.io/autorepo/docs/spring-security/3.2.0.CI-SNAPSHOT/reference/html/csrf.html
		.authorizeRequests()
//			.antMatchers("/resources/static/").permitAll()
			.antMatchers("/demo/personas").hasAnyRole("ADMIN")
			.antMatchers("/inicio").hasAnyRole("APROBADOR")
			.and().httpBasic()
			.and().formLogin().loginPage("/login").failureUrl("/denegado").permitAll()//static/login.html
			.defaultSuccessUrl("/inicio");
//			.and().logout().permitAll();
//		http.logout().logoutUrl("/logout");	
//		http.exceptionHandling().accessDeniedPage("/403.html");
		http.exceptionHandling().accessDeniedPage("/403");
	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}