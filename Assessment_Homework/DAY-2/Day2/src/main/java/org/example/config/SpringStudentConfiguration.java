package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SpringStudentConfiguration {
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                .csrf((CsrfConfigurer<HttpSecurity> csrf)->csrf.disable())
//                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    InMemoryUserDetailsManager userDetails()
//    {
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//        UserDetails st = User.builder().username("st").password(passwordEncoder().encode("st123")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,st);
//    }


//----------------------------------------------RBAC-------------------------------------------------
//---------------------------------SECURITY REQUEST-MATCHER------------------------------------------

//@Configuration
//public class SpringStudentConfiguration {
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                .csrf((CsrfConfigurer<HttpSecurity> csrf)->csrf.disable())
//                .authorizeHttpRequests(auth->{
//                        auth.requestMatchers(HttpMethod.GET,"/**").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.POST,"/studentRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.PUT,"/studentRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.DELETE,"/studentRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.GET,"/studentRBAC").hasAnyRole("ADMIN","USER");
//                        auth.anyRequest().authenticated();
//                })
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    InMemoryUserDetailsManager userDetails()
//    {
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//        UserDetails prac = User.builder().username("prac").password(passwordEncoder().encode("prac123")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,prac);
//    }

//-----------------------------------------SECURITY METHOD LEVEL TYPE-----------------------------------------

// -----------------------------------SECURITY METHOD LEVEL TYPE-----------------------------------

@Configuration
@EnableMethodSecurity
public class SpringStudentConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.
                csrf((CsrfConfigurer<HttpSecurity>csrf)->csrf.disable())
                .authorizeHttpRequests(auth->{
//                        auth.requestMatchers(HttpMethod.POST,"/studentRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.PUT,"/studentRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.DELETE,"/studentRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.GET,"/**").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.GET,"/studentRBAC").hasAnyRole("ADMIN","USER");
                    auth.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    InMemoryUserDetailsManager userDetails(){
        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
        UserDetails prac = User.builder().username("prac").password(passwordEncoder().encode("prac123")).roles("USER").build();
        return new InMemoryUserDetailsManager(admin,prac);
    }
}
