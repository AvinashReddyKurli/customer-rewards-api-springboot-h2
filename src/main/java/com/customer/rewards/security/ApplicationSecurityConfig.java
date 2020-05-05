package com.customer.rewards.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Value("${spring.security.user.name}")
	private String userName;
	
	@Value("${spring.security.user.password}")
	private String pasword;
	
	@Value("${spring.security.user.roles}")
	private String role;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers(AUTH_WHITELIST).authenticated()
        .anyRequest()
        .authenticated()//all other urls can be access by any authenticated role
        .and()
        .httpBasic().authenticationEntryPoint(swaggerAuthenticationEntryPoint());
		http.csrf().ignoringAntMatchers("/h2-console/**");
		http.headers().frameOptions().sameOrigin();
	}

	
	private static final String[] AUTH_WHITELIST = {
	        "/swagger-resources/**",
	        "/swagger-ui.html",
	        "/v2/api-docs",
	        "/webjars/**"
	};
	
	@Bean
	public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
	    BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
	    entryPoint.setRealmName("Swagger Realm");
	    return entryPoint;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser(userName)
		.password(pasword)
		.roles(role);
	}
}