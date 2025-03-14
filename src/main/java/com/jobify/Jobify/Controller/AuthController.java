package com.jobify.Jobify.Controller;


import com.jobify.Jobify.Model.Users;
import com.jobify.Jobify.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        return ResponseEntity.ok(authService.register(user));
    }
}

