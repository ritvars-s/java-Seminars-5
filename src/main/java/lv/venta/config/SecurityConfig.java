package lv.venta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//TODO nomainit lai lietotajus nem no datubazes
	@Bean
	public UserDetailsManager createTestUsers(){
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails userD1 = User.builder().username("ritvars").password(encoder.encode("")).authorities("USER").build(); 
		UserDetails userD2 = User.builder().username("janis").password(encoder.encode("")).authorities("USER").build(); 
		UserDetails userD3 = User.builder().username("admin").password(encoder.encode("")).authorities("ADMIN").build(); 
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(userD1, userD2, userD3);
		
		return manager;
		
		
	}
	
	@Bean
	public SecurityFilterChain configureEndpoints(HttpSecurity http) {
		
		http.authorizeHttpRequests(
				auth->auth
				.requestMatchers("/product/crud/all").permitAll()
				.requestMatchers("/simple/page").permitAll()
				.requestMatchers("/simple/product").permitAll()
				.requestMatchers("/simple/add").hasAuthority("ADMIN")
				.requestMatchers("/simple/products").permitAll()
				.requestMatchers("/simple/update").hasAnyAuthority("ADMIN", "USER")
				);
		
		http.formLogin(auth->auth.permitAll());
		
		//TODO prieks h2
		//http.headers(auth->auth.frameOptions().disable()); priks h2
		//http.csrf(auth -> auth.ignoringRequestMatchers("h2-console/**"))
		
		
		return http.build();
		
	}
	
	
	
}
