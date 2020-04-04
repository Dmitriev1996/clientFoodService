package com.service.clientFoodService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Admin on 08.02.2020.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {
    private String username;
    private String password;
}
