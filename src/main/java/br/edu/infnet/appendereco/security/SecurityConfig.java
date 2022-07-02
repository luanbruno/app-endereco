package br.edu.infnet.appendereco.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.infnet.appendereco.model.Repository.UsuarioDao;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/usuario/**").permitAll()
		.antMatchers("/enderecos").permitAll()
		.antMatchers("/endereco/**").hasRole("ADMIN")
		//.antMatchers("/usuario/incluir").permitAll()
		.anyRequest().authenticated().and()
		.csrf().disable()
		.formLogin()
			.loginPage("/login").permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/negado");	
	}
}
