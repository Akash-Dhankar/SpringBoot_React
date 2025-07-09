package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SpringConfiguration {
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.
//                csrf((CsrfConfigurer<HttpSecurity>csrf)->csrf.disable())
//                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    @Bean
//    InMemoryUserDetailsManager userDetails(){
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//        UserDetails ad = User.builder().username("ad").password(passwordEncoder().encode("ad123")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,ad);
//    }
//}


// ------------------------------------------------RBAC----------------------------------------------
// -----------------------------------SECURITY REQUESTMATCHER TYPE-------------------------------------

//@Configuration
//public class SpringConfiguration {
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.
//                csrf((CsrfConfigurer<HttpSecurity>csrf)->csrf.disable())
//                .authorizeHttpRequests(auth->{
//                        auth.requestMatchers(HttpMethod.POST,"/employeeRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.PUT,"/employeeRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.DELETE,"/employeeRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.GET,"/**").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.GET,"/employeeRBAC").hasAnyRole("ADMIN","USER");
//                        auth.anyRequest().authenticated();
//                })
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    @Bean
//    InMemoryUserDetailsManager userDetails(){
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//        UserDetails ad = User.builder().username("ad").password(passwordEncoder().encode("ad123")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,ad);
//    }

    // -----------------------------------SECURITY METHOD LEVEL TYPE-----------------------------------

    @Configuration
    @EnableMethodSecurity
    public class SpringConfiguration {

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
//                        auth.requestMatchers(HttpMethod.POST,"/employeeRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.PUT,"/employeeRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.DELETE,"/employeeRBAC").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.GET,"/**").hasRole("ADMIN");
//                        auth.requestMatchers(HttpMethod.GET,"/employeeRBAC").hasAnyRole("ADMIN","USER");
                        auth.anyRequest().authenticated();
                    })
                    .httpBasic(Customizer.withDefaults());
            return http.build();
        }
        @Bean
        InMemoryUserDetailsManager userDetails(){
            UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
            UserDetails ad = User.builder().username("ad").password(passwordEncoder().encode("ad123")).roles("USER").build();
            return new InMemoryUserDetailsManager(admin,ad);
        }
}