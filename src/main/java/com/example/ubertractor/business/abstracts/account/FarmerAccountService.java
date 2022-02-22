package com.example.ubertractor.business.abstracts.account;

import com.example.ubertractor.business.requests.account.CreateFarmerAccountRequest;
import com.example.ubertractor.business.requests.account.LoginRequest;
import com.example.ubertractor.core.utilities.results.Result;

public interface FarmerAccountService {
    Result add(CreateFarmerAccountRequest createFarmerAccountRequest);
    Result login(LoginRequest loginRequest);
}
