package com.ust.bankLocker.repository;

import com.ust.bankLocker.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRespository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByLoginId(String loginId);
}
