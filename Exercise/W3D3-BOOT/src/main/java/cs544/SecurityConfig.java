package cs544;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("pass")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN","USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests(auth -> auth.
                        requestMatchers("/", "/login", "/logout").permitAll()
                        .requestMatchers(HttpMethod.GET, "/books/view/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/books/add").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/books").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/books/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST,"/books/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/books/delete").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/books").hasRole("ADMIN")
                        .requestMatchers("/important/**").hasRole("USER"))
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());
        return http.build();
    }

}
