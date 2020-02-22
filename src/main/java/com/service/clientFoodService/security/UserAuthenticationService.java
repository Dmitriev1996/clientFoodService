package com.service.clientFoodService.security;

import com.service.clientFoodService.dtos.AuthenticationResponseDTO;
import com.service.clientFoodService.dtos.RegistrationRequestDTO;
import com.service.clientFoodService.entities.User;
import com.service.clientFoodService.exceptions.InvalidDataException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * Created by Admin on 05.05.2019.
 */
public interface UserAuthenticationService {

    AuthenticationResponseDTO login(String username, String password) throws InvalidDataException;
    AuthenticationResponseDTO registration(RegistrationRequestDTO userDTO) throws InvalidDataException;
    Optional<UserDetails> findByToken(String token);
    void logout(User user);
}
