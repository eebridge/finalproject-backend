package edu.iu.eebridge.finalproject.controllers;


import edu.iu.eebridge.finalproject.model.Customer;
import edu.iu.eebridge.finalproject.repository.CustomerRepository;
import edu.iu.eebridge.finalproject.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    CustomerRepository customerRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService, CustomerRepository customerRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.customerRepository = customerRepository;
    }

    @PostMapping("/signup")
    public Customer signup(@RequestBody Customer customer) {
        try {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String passwordEncoded = bc.encode(customer.getPassword());
            customer.setPassword(passwordEncoded);
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                customer.getUsername()
                                ,customer.getPassword()));
        return tokenService.generateToken(authentication);

    }
}
