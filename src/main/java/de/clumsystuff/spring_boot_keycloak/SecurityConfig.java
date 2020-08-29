package de.clumsystuff.spring_boot_keycloak;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

	private final KeycloakClientRequestFactory keycloakClientRequestFactory;

	public SecurityConfig(KeycloakClientRequestFactory keycloakClientRequestFactory) {
		this.keycloakClientRequestFactory = keycloakClientRequestFactory;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		super.configure(http);
		http.cors().disable().csrf().disable()
				//.sessionManagement()
				//.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				//.sessionAuthenticationStrategy(sessionAuthenticationStrategy()).and()
				.authorizeRequests()
				.antMatchers("/protected*").hasRole("testrole").anyRequest().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		KeycloakAuthenticationProvider keyCloakAuthProvider = this.keycloakAuthenticationProvider();
		keyCloakAuthProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());

		auth.authenticationProvider(keyCloakAuthProvider);
	}

	@Bean
	public KeycloakConfigResolver KeyCloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

	@Bean
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}
}