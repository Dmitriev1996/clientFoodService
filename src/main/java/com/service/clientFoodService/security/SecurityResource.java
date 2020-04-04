package com.service.clientFoodService.security;

import com.service.clientFoodService.dtos.AuthenticationRequestDTO;
import com.service.clientFoodService.dtos.AuthenticationResponseDTO;
import com.service.clientFoodService.dtos.RegistrationRequestDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 08.02.2020.
 */
@RestController
@RequestMapping("/api/security")
public class SecurityResource {

    @NonNull
    UserAuthenticationService userAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDTO requestDTO) throws Exception {
        try {
            return ResponseEntity.ok(userAuthenticationService.login(requestDTO.getUsername(), requestDTO.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationRequestDTO requestDTO) throws Exception {
        try {
            return ResponseEntity.ok(userAuthenticationService.registration(requestDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/greeting")
    public String helloWorld() {
        return "Hello World!";
    }
}
