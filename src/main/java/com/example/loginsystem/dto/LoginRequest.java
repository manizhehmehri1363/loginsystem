package com.example.loginsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message ="Der Benutzername darf nicht leer sein.")
    private String username;

   @NotBlank(message ="Der Password darf nicht leer sein.")
    private String password;

}
