package jp.gr.java_conf.ak.akanash.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		http.csrf().disable();

		http.authorizeRequests().anyRequest().authenticated();

		http.formLogin();
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);
	}
}
