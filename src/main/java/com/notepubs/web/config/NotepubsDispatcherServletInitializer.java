package com.notepubs.web.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class NotepubsDispatcherServletInitializer extends 
				AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {
				NotepubsSecurityConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {
				ServletContextConfig.class,
				NotepubsMvcConfig.class,
				HibernateConfig.class,
				TilesConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		return filter;
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		
		return new Filter[] {
				characterEncodingFilter()
		};
	}

}
