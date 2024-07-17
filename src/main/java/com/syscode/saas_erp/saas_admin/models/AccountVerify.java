package com.syscode.saas_erp.saas_admin.models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;

public class AccountVerify {
    
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "token_generated")
    private String tokenGenerated;
    @Column(name = "token_expired_at")
    private Timestamp tokenExpiredAt;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public AccountVerify() {
        super();
    }

    public AccountVerify(Long accountId, String tokenGenerated, Timestamp tokenExpiredAt, Timestamp createdAt,
            Timestamp updatedAt) {
        this.accountId = accountId;
        this.tokenGenerated = tokenGenerated;
        this.tokenExpiredAt = tokenExpiredAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTokenGenerated() {
        return tokenGenerated;
    }

    public void setTokenGenerated(String tokenGenerated) {
        this.tokenGenerated = tokenGenerated;
    }

    public Timestamp getTokenExpiredAt() {
        return tokenExpiredAt;
    }

    public void setTokenExpiredAt(Timestamp tokenExpiredAt) {
        this.tokenExpiredAt = tokenExpiredAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}
