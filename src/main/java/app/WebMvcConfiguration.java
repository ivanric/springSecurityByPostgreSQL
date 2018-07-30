package app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
@ComponentScan("org.springframework.security.samples.mvc")
public class WebMvcConfiguration implements WebMvcConfigurer {

//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        super.addResourceHandlers(registry);
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
////        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
////      registry.addResourceHandler("/stylesheets/**").addResourceLocations("/stylesheets/");
////      registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
////      registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/inicio").setViewName("/vistas/inicio.html");
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/salir").setViewName("logout.html");
        registry.addViewController("/welcome").setViewName("welcome.html");
        registry.addViewController("/403").setViewName("403.html");
        //registry.addViewController("/inicio2").setViewName("/static/inicio.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}