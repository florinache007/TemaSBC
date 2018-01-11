package com.tema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	 @Bean
	    public ServletContextTemplateResolver templateResolver() {
	        
		  ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	        
	        templateResolver.setPrefix("/WEB-INF/");
	        templateResolver.setCacheable(false);
	        templateResolver.setSuffix(".html");        
	        templateResolver.setTemplateMode("HTML5");
	        templateResolver.setOrder(1);
	        templateResolver.setCharacterEncoding("UTF-8");
	        
	        return templateResolver;
	    }

	    @Bean
	    public SpringTemplateEngine templateEngine() {
	        
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        templateEngine.addDialect(new LayoutDialect());
	        return templateEngine;
	    }

	    @Bean
	    public ThymeleafViewResolver viewResolver() {

	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        
	        viewResolver.setTemplateEngine(templateEngine());
	        
	        viewResolver.setCharacterEncoding("UTF-8");

	        return viewResolver;
	    }  
	    
}