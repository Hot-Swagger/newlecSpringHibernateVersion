package com.notepubs.web.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class NotepubsSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	private DataSource dataSource;*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http
			.authorizeRequests()
			//.anyRequest().authenticated() <= 모든 권한 허용시 메서드사용법
			.antMatchers("/author/**").hasAnyRole("AUTHOR")
			.and()
		.formLogin()
			.loginPage("/member/login")
			.permitAll()
			.and()
		.logout()
			.permitAll()
			.and()
		.httpBasic();
		*/
		http
			.authorizeRequests()
			//--------------------------------
			.antMatchers("/*","/note/**","/member/**").permitAll()
			.antMatchers("/resource/**").permitAll()
			.antMatchers("/aurhor/**").hasRole("AUTHOR")	//	.access("hasRole('AUTHOR') or hasRole('ADMIN')")
			//--------------------------------
			.anyRequest().authenticated()	// 모든요청에 인증이 필요하게 설정하는 내용
			.and()
		.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/member/login")	// 요청 URL이름을 변경하는 기능
			.permitAll()
			.defaultSuccessUrl("/author/index")
			.and()
		.logout()
			.logoutSuccessUrl("/index")
			.invalidateHttpSession(true)
			.and()			
		.httpBasic();
			
		http.csrf().disable();
			
			
	
	}
	
	/*이것만 설정하면 디폴트 로그인창으로 이동하여 인증할수 있다.
	  <http auto-config="true"> */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*비밀번호 암호화 없이 사용하도록 해주는 내용 (4.0버전 이후 사라짐)
		UserBuilder users = User.withDefaultPasswordEncoder();*/
		
		UserBuilder users = User.builder();
		
		/*jdbc 방식*/
		/*auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select id, pwd AS password, 1 enabled from Member where id=?")
			.authoritiesByUsernameQuery("select memberId AS id, roleId AS authority from MemberRole where memberId=?")
			.passwordEncoder(new BCryptPasswordEncoder());*/
		
		/*인메모리 방식*/
		auth.inMemoryAuthentication()
			.withUser(users.username("dskim").password("{noop}dskim").roles("ADMIN","AUTHOR"))
			.withUser(users.username("dragon").password("{noop}111").roles("AUTHOR"));
	}
}
