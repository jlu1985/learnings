import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // this adds user and password and create a login page
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
                .password("password").roles("admin");
    }

    @EnableWebSecurity
    public static class Adapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/admin/**").hasRole("admin").antMatchers("/user/**").hasRole("USER")
                    .anyRequest().authenticated().and().formLogin().permitAll().and().logout().logoutUrl("/logout").clearAuthentication(true)
                    .invalidateHttpSession(true);
        }
    }
}
