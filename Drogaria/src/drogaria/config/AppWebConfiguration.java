package drogaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import drogaria.controller.HomeController;


@EnableWebMvc
@ComponentScan(basePackageClasses= {HomeController.class})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver Resolver = new InternalResourceViewResolver();
		Resolver.setPrefix("/WEB-INF/views/");
		Resolver.setSuffix(".jsp");
		return Resolver;
	}
	
}
