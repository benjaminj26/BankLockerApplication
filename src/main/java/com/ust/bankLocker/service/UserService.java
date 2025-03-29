package com.ust.bankLocker.service;

import com.ust.bankLocker.datatypes.CreateUser;
import com.ust.bankLocker.model.User;
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

    public User createUser(CreateUser createUser) {
        User user = new User();

        user.setLoginId(createUser.getLoginId());
        user.setName(createUser.getName());
        user.setEmail(createUser.getEmail());
        user.setAddress(createUser.getAddress());
        user.setPhone(createUser.getPhone());

        User temp = userRepository.save(user);

        UserCredentials creds = new UserCredentials();

        creds.setLoginId(createUser.getLoginId());
        creds.setPassword(createUser.getPassword());
        userCredentialRespository.save(creds);

        return temp;
    }

    public User getUser(String loginId) {
        Optional<User> temp = userRepository.findByLoginId(loginId);

        return temp.orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
