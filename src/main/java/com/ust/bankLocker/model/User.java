package com.ust.bankLocker.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String loginId;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;
    private String address;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<BankLocker> bankLockers;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankLocker> getBankLockers() {
        return bankLockers;
    }

    public void setBankLockers(List<BankLocker> bankLockers) {
        this.bankLockers = bankLockers;
    }
}
