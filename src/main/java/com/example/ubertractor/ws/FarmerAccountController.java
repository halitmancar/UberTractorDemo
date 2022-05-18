package com.example.ubertractor.ws;

import com.example.ubertractor.business.abstracts.account.FarmerAccountService;
import com.example.ubertractor.business.requests.account.CreateFarmerAccountRequest;
import com.example.ubertractor.business.requests.account.LoginRequest;
import com.example.ubertractor.core.utilities.results.DataResult;
import com.example.ubertractor.core.utilities.results.ErrorDataResult;
import com.example.ubertractor.core.utilities.results.Result;
import com.example.ubertractor.core.utilities.results.SuccessDataResult;
import com.example.ubertractor.entities.account.FarmerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping("/getNameByPN")
    public DataResult<String> getNameByPN(@RequestParam String phoneNumber){
        if (this.farmerAccountService.getAccByPN(phoneNumber).getData() == null) {
            return new ErrorDataResult<String>(null, "Bu telefon numarası ile kayıtlı bir kullanıcı bulunamadı!");
        }
        String name = this.farmerAccountService.getAccByPN(phoneNumber).getData().getFullName();
        return new SuccessDataResult<String>(name);
    }
    @GetMapping("/getAll")
    public List<FarmerAccount> getAll(){
        return this.farmerAccountService.getAll().getData();
    }


}
