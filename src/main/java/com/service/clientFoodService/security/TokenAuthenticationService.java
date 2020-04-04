package com.service.clientFoodService.security;

import com.google.common.collect.ImmutableMap;
import com.service.clientFoodService.daos.UserDAO;
import com.service.clientFoodService.dtos.AuthenticationResponseDTO;
import com.service.clientFoodService.dtos.RegistrationRequestDTO;
import com.service.clientFoodService.entities.User;
import com.service.clientFoodService.exceptions.InvalidDataException;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 05.05.2019.
 */
@Service
public class TokenAuthenticationService implements UserAuthenticationService {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserDetailService userService;

    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponseDTO login(String username, String password) throws InvalidDataException {
        return new AuthenticationResponseDTO(
                Optional.of(userService
                        .loadUserByUsername(username))
                        .filter(user -> Objects.equals(
                                passwordEncoder.encode(password + user.getSalt()),
                                user.getPassword()))
                        .map(user -> tokenService.expiring(ImmutableMap.of("username", username)))
                        .orElseThrow(() -> new InvalidDataException("Неверный логин или пароль"))
        );
    }

    @Override
    public AuthenticationResponseDTO registration(RegistrationRequestDTO userDTO) throws InvalidDataException{
        UserDetails userDetails = userService.loadUserByUsername(userDTO.getUsername());
        if (userDetails != null) {
            throw new InvalidDataException("Пользователь с данным логином уже зарегистрирован");
        }
        User user = new User();
        user.setLogin(userDTO.getUsername());
        Random random = new Random();
        byte[] randBytes = new byte[10];
        random.nextBytes(randBytes);
        final String salt = new String(randBytes, Charset.forName("UTF-8"));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword() + salt));
        user.setSalt(salt);
        user.setSurname(userDTO.getSurname());
        user.setName(userDTO.getName());
        user.setPatronymic(userDTO.getPatronymic());
        user.setEmail(userDTO.getEmail());
        userDAO.save(user);
        return login(userDTO.getUsername(), userDTO.getPassword());
    }

    /*private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Override
    public Optional<UserDetails> findByToken(String token) {
        return Optional.of(userService.loadUserByUsername(tokenService.verify(token).get("username")));
    }

    @Override
    public void logout(User user) {

    }
}
