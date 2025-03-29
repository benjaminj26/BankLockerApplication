package com.ust.bankLocker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class BankLocker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lockerId;

    private boolean isAvailable;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Long getLockerId() {
        return lockerId;
    }

    public void setLockerId(Long lockerId) {
        this.lockerId = lockerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
