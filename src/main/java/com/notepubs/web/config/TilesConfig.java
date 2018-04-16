package com.notepubs.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		return resolver;
	}
}
