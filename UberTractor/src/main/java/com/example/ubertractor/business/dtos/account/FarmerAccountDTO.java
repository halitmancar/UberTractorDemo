package com.example.ubertractor.business.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerAccountDTO {
    private int accountId;
    private String phoneNumber;
    private String password;
}
