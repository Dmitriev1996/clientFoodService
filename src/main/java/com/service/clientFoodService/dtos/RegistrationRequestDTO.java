package com.service.clientFoodService.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Admin on 09.02.2020.
 */
@Getter
@Setter
public class RegistrationRequestDTO {
    private String username;
    private String password;
    private String email;
    private String surname;
    private String name;
    private String patronymic;
}
