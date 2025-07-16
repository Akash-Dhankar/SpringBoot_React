package com.example.demo.config;

import com.example.demo.jwt.JwtAuthenticationFilter;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

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

//@Configuration
//@EnableMethodSecurity
//public class SpringConfiguration {
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers(HttpMethod.POST, "/api/auth/register", "/api/auth/login").permitAll();
//                    auth.requestMatchers(HttpMethod.GET, "/employeeDTO").hasAnyRole("ADMIN", "USER");
//                    auth.anyRequest().authenticated();
//                })
//                .userDetailsService(customUserDetailsService)
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//}
// ---------------------------------------------THIS WILL BE COMMENTED FOR DAY 7 ALSO -----------------------------------------

//        @Bean
//        InMemoryUserDetailsManager userDetails(){
//            UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//            UserDetails ad = User.builder().username("ad").password(passwordEncoder().encode("ad123")).roles("USER").build();
//            return new InMemoryUserDetailsManager(admin,ad);
//        }


//-------------------------------------------------DAY 8 JWT--------------------------------------------------------

//@Configuration
//@EnableMethodSecurity
//public class SpringConfiguration {
//
//    @Autowired
//    CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/api/auth/**").permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
//        return configuration.getAuthenticationManager();
//    }

//-----------------------------------------------------DAY 9 WITH REACT----------------------------------------

@Configuration
@EnableMethodSecurity
public class SpringConfiguration {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/auth/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173", "https://springboot-classes.onrender.com","https://ems-latest.onrender.com"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
