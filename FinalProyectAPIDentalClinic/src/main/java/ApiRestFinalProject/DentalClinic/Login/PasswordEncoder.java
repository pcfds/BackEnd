package ApiRestFinalProject.DentalClinic.Login;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class PasswordEncoder {


    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
