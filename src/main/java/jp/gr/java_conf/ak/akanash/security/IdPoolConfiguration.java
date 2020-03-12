package jp.gr.java_conf.ak.akanash.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class IdPoolConfiguration {

	@Bean
	public UserDetailsService userDetailsService(final PasswordEncoder passwordEncoder) {
		return (username) -> User.builder().username(username).password(passwordEncoder.encode("password"))
				.authorities("ROLE_USER").build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
