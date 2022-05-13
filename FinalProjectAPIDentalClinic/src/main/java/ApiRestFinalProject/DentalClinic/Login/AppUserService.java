package ApiRestFinalProject.DentalClinic.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow( () -> new UsernameNotFoundException("User email not found"));
    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new AppUserService(userRepository);
    }
}
