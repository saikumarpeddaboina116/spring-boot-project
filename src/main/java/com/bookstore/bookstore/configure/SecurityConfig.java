package com.bookstore.bookstore.configure;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource securityDataSource;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String role = "ADMIN";
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("USER", role)
                .antMatchers("/user/**").hasAnyRole("USER", role)
                .antMatchers("/book/**").hasAnyRole("USER", role)
                    .and()
                    .formLogin().loginPage("/loginPage")
                    .defaultSuccessUrl("/home",true)
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll().and().logout().permitAll().and()
                    .exceptionHandling().accessDeniedPage("/access-denied");
        }

    }

