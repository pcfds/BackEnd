package ApiRestFinalProject.DentalClinic.Login;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepo;

    public DataLoader(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("password");
        String password2 = encoder.encode("password2");


//        userRepo.save(new AppUser("Pedro", "pepicf", "pedro@gmail.com", password, AppUserRoles.ADMIN));
//        userRepo.save(new AppUser("Pedro2", "pepicf2", "pepi@gmail.com", password2, AppUserRoles.USER));
    }

    public void run2(AppUser user) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        user.setRoles(AppUserRoles.USER);


        userRepo.save(user);
    }
}
