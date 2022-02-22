package com.example.ubertractor.ws;

import com.example.ubertractor.business.abstracts.account.FarmerAccountService;
import com.example.ubertractor.business.requests.account.CreateFarmerAccountRequest;
import com.example.ubertractor.business.requests.account.LoginRequest;
import com.example.ubertractor.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class FarmerAccountController {
    private FarmerAccountService farmerAccountService;

    @Autowired
    public FarmerAccountController(FarmerAccountService farmerAccountService) {
        this.farmerAccountService = farmerAccountService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateFarmerAccountRequest createFarmerAccountRequest){
        return this.farmerAccountService.add(createFarmerAccountRequest);
    }
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginRequest loginRequest){
        return this.farmerAccountService.login(loginRequest);
    }
}
