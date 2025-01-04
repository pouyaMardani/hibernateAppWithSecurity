package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {





    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager =  new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery("select username,password,active FROM members WHERE username=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role FROM roles WHERE user_id= (select id FROM members WHERE username=?)");

        return userDetailsManager;
    }



    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http)throws Exception{


        http.authorizeHttpRequests(cfg ->
                 cfg/*.requestMatchers(HttpMethod.GET,"/employees/list").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET,"/employees/showFormForAdd").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/employees/save").hasRole("EMPLOYEE")*/
                    .requestMatchers(HttpMethod.GET,"/employees/showFormForUpdate").hasAnyRole("MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.GET,"/employees/delete").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET,"/member/showMembers").hasRole("ADMIN")
                         .requestMatchers("/ok/**").permitAll()
                         .requestMatchers("/member/save").permitAll()
                         .anyRequest().authenticated()
        )
                .formLogin(form ->{
                    form
                            .loginPage("/loginPage")
                            .loginProcessingUrl("/authenticateToUrl")
                            .permitAll();
                })
                .logout(logout -> {
                    logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/loginPage?logout")
                            .permitAll();
                })
                .exceptionHandling(exception -> {
                    exception
                            .accessDeniedPage("/access-denied");
                });

        return http.build();

    }


   /* @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager (){

        UserDetails join = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();


        return new InMemoryUserDetailsManager(join,mary,susan);
    }*/



}
