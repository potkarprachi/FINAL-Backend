package com.efarmer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig 
{	
	@Autowired
	private JwtAuthFilter jwtFilter;
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		return new UserInfoUserDetailsService(); 
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf().disable()
				   .authorizeHttpRequests()
				   .antMatchers("/userLogin","/userAdd","/userquery").permitAll()
				   .and()
				   .authorizeHttpRequests()
				   .antMatchers("/addCrop/{id}").authenticated()
				   .and().sessionManagement()
				   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				   .and()
				   .authenticationProvider(authenticationProvider())
				   .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class).build();

	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	 
	 @Bean
	 public AuthenticationProvider authenticationProvider()
	 {
		 DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		 authenticationProvider.setUserDetailsService(userDetailsService());
		 authenticationProvider.setPasswordEncoder(passwordEncoder());
		 return authenticationProvider;
	 }
	 

	 @Bean
	 public AuthenticationManager authenticatonManager(AuthenticationConfiguration config) throws Exception 
	 {
		 return config.getAuthenticationManager();
}

}
