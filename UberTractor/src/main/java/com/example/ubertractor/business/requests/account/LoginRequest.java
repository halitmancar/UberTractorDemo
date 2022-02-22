package com.example.ubertractor.business.requests.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotNull
    private String phoneNumber;

    @NotNull
    private String password;
}
