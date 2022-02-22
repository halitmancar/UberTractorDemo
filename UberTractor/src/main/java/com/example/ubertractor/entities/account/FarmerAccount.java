package com.example.ubertractor.entities.account;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Accounts")
public class FarmerAccount {
    @Id
    private String accountId;

    private String fullName;

    private String phoneNumber;

    private String password;

    private int IS_ACTV;
}
