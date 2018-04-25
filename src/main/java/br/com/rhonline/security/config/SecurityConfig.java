package br.com.rhonline.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.rhonline.security.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 private LoggingAccessSuccessHandler accessSucessHandler;

	@Autowired
    private UserService userService;

	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
             .anyRequest().authenticated()
         .and()
             .formLogin()
                 .loginPage("/login")
                 	 .successHandler(accessSucessHandler)
                     .permitAll()
         .and()
             .logout()
                 .invalidateHttpSession(true)
                 .clearAuthentication(true)
                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                 .logoutSuccessUrl("/login?logout")
         .permitAll();
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

	@Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/registration", "/h2/*" ,"/js/**", "/css/**", "/img/**", "/webjars/**");
	}
}
