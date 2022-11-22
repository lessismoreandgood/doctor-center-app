package com.example.doctorcenterapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.doctorcenterapp.config.ApplicationUserPermission.*;
import static com.example.doctorcenterapp.config.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/**").hasAuthority(USER_WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/appointment/**").hasAuthority(USER_READ.getPermission())
                .antMatchers(HttpMethod.GET, "/doctor/**").hasAuthority(DOCTOR_READ.getPermission())
                .antMatchers(HttpMethod.GET, "/appointment/**").hasAuthority(DOCTOR_READ.getPermission())
                .antMatchers("/**").hasAnyRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
//                        .roles("USER")
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails doctor = User.builder()
                .username("doctor")
                .password(passwordEncoder().encode("doctor"))
//                        .roles("DOCTOR")
                .authorities(DOCTOR.getGrantedAuthorities())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
//                        .roles("ADMIN")
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(user, doctor, admin);
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
