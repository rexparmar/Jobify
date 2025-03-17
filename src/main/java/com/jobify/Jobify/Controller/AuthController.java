package com.jobify.Jobify.Controller;


import com.jobify.Jobify.Model.Users;
import com.jobify.Jobify.Repository.UserRepository;
import com.jobify.Jobify.Service.AuthService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user) throws Exception{
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.ok("Email already associated with another user. Please use another email.");
        }
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {

    }
}

