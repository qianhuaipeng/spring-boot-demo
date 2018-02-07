package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * author: alan.peng
 * description:
 * date: create in 16:35 2018/2/6
 * modified By：
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.admin.username}")
    private String adminUsername;
    @Value("${security.admin.password}")
    private String adminPassword;
    @Value("${security.user.username}")
    private String username;
    @Value("${security.user.password}")
    private String password;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests()
        //        .antMatchers("/").permitAll()
        //        .antMatchers("/sample/**").access("hasRole('ADMIN')")
        //        .anyRequest().authenticated();
        //http.csrf().disable();
        //super.configure(http);

        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        super.configure(http);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/DATAS/**");
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(adminUsername).password(adminPassword).roles("ADMIN").roles("ACTUATOR")
                .and()
                .withUser(username).password(password).roles("USER").roles("ACTUATOR");

        //this.disableLocalConfigureAuthenticationBldr = true;
        //super.configure(auth);
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
