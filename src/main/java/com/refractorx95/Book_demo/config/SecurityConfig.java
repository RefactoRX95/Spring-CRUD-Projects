package com.refractorx95.Book_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.swing.plaf.PanelUI;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetailsOne = User.withUsername("User1")
                .password(passwordEncoder().encode("Pass1")).build();
        UserDetails userDetailsTwo = User.withUsername("User2")
                .password(passwordEncoder().encode("Pass2")).build();
        UserDetails admin = User.withUsername("Admin")
                .password(passwordEncoder().encode("Admin1")).build();

        return new InMemoryUserDetailsManager(userDetailsOne,
                userDetailsTwo,admin);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeHttpRequests(request ->
                request.requestMatchers("/book-store/welcome").permitAll()
                        .anyRequest().authenticated());
    }

}
