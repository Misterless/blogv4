package site.metacoding.blogv4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //이거없으면 포스트맨 테스트 못해요
        http.authorizeRequests()
        .antMatchers("/s/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .loginPage("/loginForm")
        .defaultSuccessUrl("/");
       // super.configure(http);
    }

    
}