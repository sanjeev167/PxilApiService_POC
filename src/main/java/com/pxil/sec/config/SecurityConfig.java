
package com.pxil.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pxil.sec.filter.JwtAuthFilter;
import com.pxil.sec.service.UserInfoService; 
  
/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 9:34:18 pm 
 * Objective: This is a main security class which has been annotated with three annotation and their inbuilt features.
 * @Configuration  : It allows you to define beans within this class.
 * @EnableWebSecurity : It enables inbuilt feature of web security which can be configured for web url only.
 * @EnableMethodSecurity : It includes method level security. We can add role over a method to restrict the access even if the user is authenticated 
 * and not having right authorization.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {	

	@Autowired
    private JwtAuthFilter jwtAuthFilter;
  
    // User Creation 
    @Bean
    public UserDetailsService userDetailsService() { 
        return new UserInfoService(); 
    } 
  
    // Configuring HttpSecurity 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
        return http.csrf().disable()                             
        		.authorizeHttpRequests().antMatchers("/pub/v1/**", "/auth/v1/login","/auth/v1/refreshToken").permitAll()   
                
        		.and()                            
                .authorizeHttpRequests().antMatchers("/pvt/v1/reg/**").authenticated()//Secured access                        
                
                .and()
                .authorizeHttpRequests().antMatchers("/pvt/v1/sldc/**").authenticated()//Secured access               
                
                .and()
                .authorizeHttpRequests().antMatchers("/sec/v1/**").authenticated()//Secured access    
                
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
                
                .and() 
                .authenticationProvider(authenticationProvider()) 
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) 
                
                .build(); 
    } 
  
    // Password Encoding. This bean is being used for encrypting coming password before authentication call is made
    @Bean
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    } 
  
    //This is a dao based authentication provider which loads userDetails from database.
    @Bean
    public AuthenticationProvider authenticationProvider() { 
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); 
        authenticationProvider.setUserDetailsService(userDetailsService()); 
        authenticationProvider.setPasswordEncoder(passwordEncoder()); 
        return authenticationProvider; 
    } 
  
    //This is the authentication manager which is using authentication provider that has been defined above.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception { 
        return config.getAuthenticationManager(); 
    } 
}//End of SecurityConfig
