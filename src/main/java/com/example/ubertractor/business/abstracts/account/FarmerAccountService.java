package com.example.ubertractor.business.abstracts.account;

import com.example.ubertractor.business.requests.account.CreateFarmerAccountRequest;
import com.example.ubertractor.business.requests.account.LoginRequest;
import com.example.ubertractor.core.utilities.results.DataResult;
import com.example.ubertractor.core.utilities.results.Result;
import com.example.ubertractor.entities.account.FarmerAccount;

public interface FarmerAccountService {
    Result add(CreateFarmerAccountRequest createFarmerAccountRequest);
    Result login(LoginRequest loginRequest);
    DataResult<FarmerAccount> getAccByPN(String phoneNumber);
}
