package kz.team3.registration.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       PasswordEncoder passwordEncoder,
                                                       UserDetailsService userDetailsService)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "api/v1/user/list").hasAnyRole("ADMIN", "ACCOUNTANT", "SUPERVISOR")
                .antMatchers(HttpMethod.POST, "api/v1/user/create").anonymous()
                .antMatchers(HttpMethod.POST, "api/v1/users/{userId}/beds").hasAnyRole("SUPERVISOR", "ADMIN", "ACCOUNTANT", "STUDENT")
                .antMatchers(HttpMethod.POST, "api/v1/update/{id}").hasAnyRole("SUPERVISOR", "ADMIN", "ACCOUNTANT", "STUDENT")
                .antMatchers(HttpMethod.POST, "pi/v1/update/{id}/password").hasAnyRole("SUPERVISOR", "ADMIN", "ACCOUNTANT", "STUDENT")
                .antMatchers(HttpMethod.POST, "api/v1/user/addUser").hasAnyRole("SUPERVISOR")
                .antMatchers(HttpMethod.POST, "api/v1/beds/create").hasAnyRole("ADMIN", "SUPERVISOR")
                .antMatchers(HttpMethod.POST, "api/v1/beds/beds").hasAnyRole("ADMIN", "SUPERVISOR", "ACCOUNTANT", "STUDENT")
                .antMatchers(HttpMethod.POST, "api/v1/get/{id}").hasAnyRole("SUPERVISOR", "ADMIN", "ACCOUNTANT")
                .antMatchers(HttpMethod.POST, "api/v1/delete/{id}").hasAnyRole("SUPERVISOR", "ADMIN", "ACCOUNTANT")
                .antMatchers(HttpMethod.POST, "api/v1/{id}/balance").hasAnyRole("SUPERVISOR", "ACCOUNTANT")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }


}