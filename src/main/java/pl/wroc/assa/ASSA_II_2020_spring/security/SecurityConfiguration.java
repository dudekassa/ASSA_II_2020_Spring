package pl.wroc.assa.ASSA_II_2020_spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/is_adult", "/is_valid_number").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin().permitAll()
                .and()
                    .logout().permitAll();
    }
}
