import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebAppInit extends AbstractSecurityWebApplicationInitializer {
    public WebAppInit() {
        // this add config to filter
        super(SecurityConfig.class);
    }
}
