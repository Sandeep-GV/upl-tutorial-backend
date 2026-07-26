package com.upl.upl_tutorial_backend.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;


import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.config.http.SessionCreationPolicy;


import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableMethodSecurity
public class SecurityConfig {



    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    private final UserDetailsService userDetailsService;





    public SecurityConfig(

            JwtAuthenticationFilter jwtAuthenticationFilter,

            UserDetailsService userDetailsService

    ){

        this.jwtAuthenticationFilter = jwtAuthenticationFilter;

        this.userDetailsService = userDetailsService;

    }









    @Bean
    public SecurityFilterChain securityFilterChain(

            HttpSecurity http

    ) throws Exception {



        http



                .csrf(csrf -> csrf.disable())



                .sessionManagement(session ->

                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )

                )





                .authorizeHttpRequests(auth -> auth





                        // ==========================
                        // AUTH MODULE
                        // ==========================

                        .requestMatchers(
                                "/auth/**"
                        )
                        .permitAll()





                        // ==========================
                        // ADMIN MODULE
                        // ==========================

                        .requestMatchers(
                                "/admin/**"
                        )
                        .hasRole("ADMIN")






                        // ==========================
                        // STUDENT DASHBOARD
                        // ==========================

                        .requestMatchers(
                                "/student/dashboard/**"
                        )
                        .hasAnyRole(
                                "STUDENT",
                                "ADMIN"
                        )







                        // ==========================
                        // STUDENT HISTORY
                        // ==========================

                        .requestMatchers(
                                "/student/history/**"
                        )
                        .hasAnyRole(
                                "STUDENT",
                                "ADMIN"
                        )







                        // ==========================
                        // STUDENT MODULE OTHER APIs
                        // ==========================

                        .requestMatchers(
                                "/student/**"
                        )
                        .hasAnyRole(
                                "STUDENT",
                                "ADMIN"
                        )







                        // ==========================
                        // ENROLLMENT MODULE
                        // ==========================

                        .requestMatchers(
                                "/enrollments/**"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "STUDENT",
                                "INSTRUCTOR"
                        )







                        // ==========================
                        // COURSE MODULE
                        // ==========================

                        .requestMatchers(
                                "/courses/**"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR",
                                "STUDENT"
                        )







                        // ==========================
                        // TUTORIAL MODULE
                        // ==========================

                        .requestMatchers(
                                "/tutorials/**"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR",
                                "STUDENT"
                        )







                        // ==========================
                        // INSTRUCTOR APPROVAL
                        // ==========================

                        .requestMatchers(
                                "/instructors/approve/**"
                        )
                        .hasRole("ADMIN")







                        // ==========================
                        // INSTRUCTOR MODULE
                        // ==========================

                        .requestMatchers(
                                "/instructors/**"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR"
                        )







                        // ==========================
                        // ANY OTHER REQUEST
                        // ==========================

                        .anyRequest()
                        .authenticated()

                )







                .authenticationProvider(
                        authenticationProvider()
                )







                .addFilterBefore(

                        jwtAuthenticationFilter,

                        UsernamePasswordAuthenticationFilter.class

                );



        return http.build();

    }









    @Bean
    public AuthenticationProvider authenticationProvider(){



        DaoAuthenticationProvider provider =

                new DaoAuthenticationProvider(
                        userDetailsService
                );



        provider.setPasswordEncoder(
                passwordEncoder()
        );



        return provider;

    }









    @Bean
    public AuthenticationManager authenticationManager(

            AuthenticationConfiguration configuration

    ) throws Exception {



        return configuration.getAuthenticationManager();

    }









    @Bean
    public BCryptPasswordEncoder passwordEncoder(){


        return new BCryptPasswordEncoder();

    }


}