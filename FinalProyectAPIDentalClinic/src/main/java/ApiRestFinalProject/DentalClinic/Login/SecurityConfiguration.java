package ApiRestFinalProject.DentalClinic.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/login").permitAll()
                .antMatchers("/api/v1/register").permitAll()
                .antMatchers("/api/v1/users").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/**").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists/**").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists/{idDentist}").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists/{idDentist}/appointments").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists/{idDentist}/appointments/**").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists/{idDentist}/appointments/{idAppointment}").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists/{idDentist}/appointments/{idAppointment}/payments").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/users/{id}/dentists/{idDentist}/appointments/{idAppointment}/payments/**").hasAnyAuthority("ADMIN");
    }
}
