package com.example.ubertractor.business.requests.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFarmerAccountRequest {

    @NotNull
    private String fullName;

    @NotNull
    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotNull
    private String password;

    @NotNull
    private String passwordConfirmation;

}
