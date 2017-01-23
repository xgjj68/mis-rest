package authority;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
@EnableWebSecurity 
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter   {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/authority.html").hasRole("ADMIN")
		.and()
		.formLogin()
		.and()
        .logout()
           .deleteCookies("remove")
           .invalidateHttpSession(false)
           .logoutUrl("/custom-logout")
           .logoutSuccessUrl("/logout-success");

		http.headers().frameOptions().disable();
		//关闭csrf 防止循环定向
		http.csrf().disable();

	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		//web.ignoring().antMatchers("/webapp/**");
		System.out.println("hjjhjhj");
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		 auth
         .inMemoryAuthentication()
              .withUser("admins")
                   .password("password")
                   .roles("ADMIN");
	}
}
