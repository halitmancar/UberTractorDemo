package com.example.ubertractor.business.concretes.account;

import com.example.ubertractor.business.abstracts.account.FarmerAccountService;
import com.example.ubertractor.business.requests.account.CreateFarmerAccountRequest;
import com.example.ubertractor.business.requests.account.LoginRequest;
import com.example.ubertractor.core.utilities.businessrule.BusinessRules;
import com.example.ubertractor.core.utilities.mapping.ModelMapperService;
import com.example.ubertractor.core.utilities.results.*;
import com.example.ubertractor.dataAccess.account.FarmerAccountDao;
import com.example.ubertractor.entities.account.FarmerAccount;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FarmerAccountManager implements FarmerAccountService {
    private FarmerAccountDao farmerAccountDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public FarmerAccountManager(FarmerAccountDao farmerAccountDao, ModelMapperService modelMapperService) {
        this.farmerAccountDao = farmerAccountDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateFarmerAccountRequest createFarmerAccountRequest) {
        Result result = BusinessRules.run(checkExistingPhoneNumber(createFarmerAccountRequest.getPhoneNumber()));
        if (result != null){
            return result;
        }
        FarmerAccount account = modelMapperService.forRequest().map(createFarmerAccountRequest, FarmerAccount.class);
        account.setAccountId(UUID.randomUUID().toString());
        account.setIS_ACTV(1);
        if ((createFarmerAccountRequest.getPassword()).equals(createFarmerAccountRequest.getPasswordConfirmation())){
            this.farmerAccountDao.save(account);
            return new SuccessResult("Hesap oluşturuldu!");
        } else{
            return new ErrorResult("Şifre eşleşmiyor!");
        }
    }

    @Override
    public Result login(LoginRequest loginRequest) {
        Result result = BusinessRules.run( checkAccountByPassword(loginRequest));
        if (result != null){
            return result;
        }
        return new SuccessResult("Giriş başarılı!");
    }

    @Override
    public DataResult<FarmerAccount> getAccByPN(String phoneNumber) {
        FarmerAccount acc = this.farmerAccountDao.getByPhoneNumber(phoneNumber);
        return new SuccessDataResult<FarmerAccount>(acc);
    }

    private Result checkAccountByPassword(LoginRequest loginRequest) {
        FarmerAccount account = this.farmerAccountDao.getByPhoneNumber(loginRequest.getPhoneNumber());
        if (account != null) {
            if ((account.getPassword()).equals(loginRequest.getPassword())) {
                return new SuccessResult();
            }
            return new ErrorResult("Şifre yanlış!");
        }
        return new ErrorResult("Telefon numarası geçersiz!");
    }

    private Result checkExistingPhoneNumber(String phoneNumber){
        if(this.farmerAccountDao.existsByPhoneNumber(phoneNumber) == false){
            return new SuccessResult();
        }
        return new ErrorResult("Bu telefon numarası ile daha önce kayıt oluşturulmuş!");
    }

    private Result checkIfPNExists(String phoneNumber){
        if (this.farmerAccountDao.existsByPhoneNumber(phoneNumber)){
            return new SuccessResult();
        }
        return new ErrorResult("Bu telefon numarası ile kayıtlı bir kullanıcı bulunamadı!");
    }

}
