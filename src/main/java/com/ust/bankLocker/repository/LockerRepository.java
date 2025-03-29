package com.ust.bankLocker.repository;

import com.ust.bankLocker.model.BankLocker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepository extends JpaRepository<BankLocker, Long> {
}
