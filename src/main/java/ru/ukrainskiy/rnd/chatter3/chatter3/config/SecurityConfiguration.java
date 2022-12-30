package ru.ukrainskiy.rnd.chatter3.chatter3.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    private final DataSource dataSource;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public void allAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .eraseCredentials(false)
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(
                        "select login as username, password_bcrypt as password, active as enabled from user_chatter where login = ?")
                .authoritiesByUsernameQuery(
                        "select ur.* from user_role ur join user_chatter uc on uc.user_role_id = ur.id where uc.login = ?");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable();

        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/",
                                "/api/auth/**",
                                "/swagger-ui/**",
                                "/api/v1/user/login",
                                "/v3/api-docs/**",
                                "/api/signup")
                        .permitAll()
                        .anyRequest()
                        .authenticated());

        http.formLogin()
                .loginProcessingUrl("/api/v1/user/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .logout()
                .logoutUrl("/api/v1/user/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint);

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

    @Bean
    public WebSecurityCustomizer webSecurity() {
            return web -> web.ignoring().requestMatchers("/profile", "/userChatterEntities", "/userRoleEntities");
    }
    
//     @Bean
//     static GrantedAuthorityDefaults grantedAuthorityDefaults() {
//             return new GrantedAuthorityDefaults("");
//     }

}
