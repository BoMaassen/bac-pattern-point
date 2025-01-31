package nl.bo.bacpatternpoint.config;

import nl.bo.bacpatternpoint.security.JwtRequestFilter;
import nl.bo.bacpatternpoint.security.JwtService;
import nl.bo.bacpatternpoint.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtService jwtService) throws Exception {

        http
                .httpBasic(hb -> hb.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api-docs/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()

                        .requestMatchers(HttpMethod.GET, "/users/{id}").hasAnyRole("HAKER", "PATROONMAKER")
                        .requestMatchers(HttpMethod.PUT, "/users/{id}").hasAnyRole("HAKER", "PATROONMAKER")
                        .requestMatchers(HttpMethod.DELETE, "/users/{id}").hasAnyRole("HAKER", "PATROONMAKER")

                        .requestMatchers(HttpMethod.GET, "/posts/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/posts").hasRole("HAKER")
                        .requestMatchers(HttpMethod.GET, "/posts/{id}").hasAnyRole("HAKER", "PATROONMAKER")
                        .requestMatchers(HttpMethod.PUT, "/posts/{id}").hasRole("HAKER")
                        .requestMatchers(HttpMethod.DELETE, "/posts/{id}").hasRole("HAKER")

                        .anyRequest().denyAll()
                )
                .addFilterBefore(new JwtRequestFilter(jwtService), UsernamePasswordAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

        return builder.build();
    }
}
