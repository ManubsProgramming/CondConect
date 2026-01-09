package com.sistema.CondConnect.Security;

import com.sistema.CondConnect.Services.UsersDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    public SecurityConfig(UsersDetailsService usersDetailsService) {
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login", "/auth/home").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
    .loginPage("/auth/login")
    .loginProcessingUrl("/auth/login")
    .defaultSuccessUrl("/auth/home", true)
    .failureUrl("/auth/login?error=true")
    .permitAll()
)

            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
