package com.ust.bankLocker.service;

import com.ust.bankLocker.datatypes.CreateUser;
import com.ust.bankLocker.model.Users;
import com.ust.bankLocker.model.UserCredentials;
import com.ust.bankLocker.repository.UserCredentialRespository;
import com.ust.bankLocker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserCredentialRespository userCredentialRespository;

    @Autowired
    public UserService(
            UserRepository userRepository,
            UserCredentialRespository userCredentialRespository
    ) {
        this.userRepository = userRepository;
        this.userCredentialRespository = userCredentialRespository;
    }

    public Users createUser(CreateUser createUser) {
        Users users = new Users();

        users.setLoginId(createUser.getLoginId());
        users.setName(createUser.getName());
        users.setEmail(createUser.getEmail());
        users.setAddress(createUser.getAddress());
        users.setPhone(createUser.getPhone());

        Users temp = userRepository.save(users);

        UserCredentials creds = new UserCredentials();

        creds.setLoginId(createUser.getLoginId());
        creds.setPassword(createUser.getPassword());
        userCredentialRespository.save(creds);

        return temp;
    }

    public Users getUser(String loginId) {
        Optional<Users> temp = userRepository.findByLoginId(loginId);

        return temp.orElse(null);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
