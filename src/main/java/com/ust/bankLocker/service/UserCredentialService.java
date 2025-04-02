package com.ust.bankLocker.service;

import com.ust.bankLocker.datatypes.CreateUser;
import com.ust.bankLocker.datatypes.Login;
import com.ust.bankLocker.model.UserCredentials;
import com.ust.bankLocker.repository.UserCredentialRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialService {

    private final UserCredentialRespository userCredentialRespository;

    @Autowired
    public UserCredentialService(UserCredentialRespository userCredentialRespository) {
        this.userCredentialRespository = userCredentialRespository;
    }

    public UserCredentials createUser(CreateUser createUser) {
        UserCredentials creds = new UserCredentials();
        creds.setLoginId(createUser.getLoginId());
        creds.setPassword(createUser.getPassword());
        return userCredentialRespository.save(creds);
    }

    public boolean isAuthorised(Login loginData) {
        Optional<UserCredentials> credentials = userCredentialRespository.findByLoginId(loginData.getLoginId());

        return credentials.map(userCredentials -> userCredentials.getPassword().equals(loginData.getPassword())).orElse(false);
    }
}
