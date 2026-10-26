package com.org.ailms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // Swagger
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // Authentication APIs
                        .requestMatchers("/api/auth/**")
                        .permitAll()

                        // User
                        .requestMatchers("/api/v1/user/get/**")
                        .hasAnyRole("ADMIN", "STUDENT")

                        // Student can create enrollment
                        .requestMatchers("/api/v1/enrollment/create")
                        .hasAnyRole("STUDENT","ADMIN")

                        .requestMatchers("/api/v1/user/update/**")
                        .hasAnyRole("ADMIN","STUDENT")

                        // Student + Admin can see user's enrollments
                        .requestMatchers("/api/v1/enrollment/user/**")
                        .hasAnyRole("ADMIN", "STUDENT")

                        // Other enrollment operations - Admin
                        .requestMatchers("/api/v1/enrollment/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/api/v1/lesson/getlessonbycourseid/**")
                        .hasAnyRole("ADMIN","STUDENT")

                        // Lesson - Admin
                        .requestMatchers("/api/v1/lesson/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/v1/course/**").hasAnyRole("ADMIN", "STUDENT")


                        .requestMatchers("/api/v1/course/getAll")
                        .hasAnyRole("ADMIN","STUDENT")

                        // Course - Admin
                        .requestMatchers("/api/v1/course/**")
                        .hasRole("ADMIN")

                        // Everything else
                        .anyRequest()
                        .authenticated()
                )

                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig){
        return authConfig.getAuthenticationManager();
    }
    
}