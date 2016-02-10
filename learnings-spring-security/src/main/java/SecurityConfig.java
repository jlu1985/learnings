import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //this adds user and password and create a login page
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }
}
