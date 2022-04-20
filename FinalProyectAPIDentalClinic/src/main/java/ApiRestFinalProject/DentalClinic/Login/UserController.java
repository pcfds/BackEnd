package ApiRestFinalProject.DentalClinic.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
    @Autowired
    private DataLoader loader;



    @PostMapping("/loginUser")
    public void  loginUser(@RequestBody AppUser user) throws Exception {
         loader.run2(user);
    }



    @GetMapping("/user")
    public String user() {
        return "<h1> Welcome User to your Dental Service </h1>";
    }
    @GetMapping("/admin")
    public String admin() {
        return "<h1> Welcome Admin to your Dental Service </h1>";
    }
    }
