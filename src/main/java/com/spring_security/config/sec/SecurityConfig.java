package com.spring_security.config.sec;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .requiresChannel(channel -> channel.anyRequest().requiresSecure())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/", "/api/home").permitAll()
                                .requestMatchers("/api/manager").hasAnyRole("MANAGER", "ADMIN")
                                .requestMatchers("/api/admin").hasRole("ADMIN")
                                .requestMatchers("api/profile").authenticated()
                                .requestMatchers("/api/client").hasAuthority("ROLE_CLIENT")
                                .requestMatchers("/api/client2").hasRole("CLIENT")
                                .requestMatchers("/basic1").hasAuthority("ACCESS_BASIC1")
                                .requestMatchers("/basic1").hasAuthority("ACCESS_BASIC1")
                )
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());

        return httpSecurity.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("user").password(encoder().encode("user1234")).roles("USER").authorities("ACCESS_BASIC1").build();
        UserDetails admin = User.withUsername("admin").password(encoder().encode("admin1234")).roles("ADMIN").build();
        UserDetails manger = User.withUsername("manager").password(encoder().encode("manager1234")).roles("MANAGER").build();
        UserDetails client = User.withUsername("client").password(encoder().encode("client1234")).authorities("ROLE_CLIENT").build();

        return new InMemoryUserDetailsManager(user, admin, manger, client);
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
