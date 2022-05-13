package ApiRestFinalProject.DentalClinic.Controller;

import ApiRestFinalProject.DentalClinic.Login.AppUserService;
import ApiRestFinalProject.DentalClinic.Login.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JwtController {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private AppUserService userDetailsService;
//    @Autowired
//    private JwtUtil JwtUtil;
//
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        }catch (BadCredentialsException e) {
//            throw new Exception("Incorrect", e);
//        }
//        final UserDetails userDetails = App.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt = JwtUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse((jwt)));
//    }
//
//    @RequestMapping({"/hello"})
//    public String hello() {
//        return "Hello World";
//    }
}
