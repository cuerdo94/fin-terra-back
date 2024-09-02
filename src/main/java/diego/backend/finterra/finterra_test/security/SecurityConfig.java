package diego.backend.finterra.finterra_test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import diego.backend.finterra.finterra_test.exceptions.customs.CustomAuthenticationEntryPoint;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

  public SecurityConfig(CustomAuthenticationEntryPoint customAuthenticationEntryPoint) {
    this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
        (requests) -> requests
            .requestMatchers(HttpMethod.GET, "/api/prueba/no-authorized").authenticated()
            .requestMatchers(HttpMethod.GET, "/api/prueba/authorized").permitAll()
            .anyRequest().authenticated())
        .httpBasic(withDefaults())
        .exceptionHandling(
            exceptionHandling -> exceptionHandling.authenticationEntryPoint(customAuthenticationEntryPoint))
        .build();
  }

  @Bean
  UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("Diego")
        .password("{noop}12345")
        .roles("USER")
        .build());
    return manager;
  }

}
