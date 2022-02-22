package com.example.ubertractor.dataAccess.account;

import com.example.ubertractor.entities.account.FarmerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerAccountDao extends JpaRepository<FarmerAccount, Integer> {
boolean existsByPhoneNumber(String phoneNumber);
FarmerAccount getByPhoneNumber(String phoneNumber);
}
