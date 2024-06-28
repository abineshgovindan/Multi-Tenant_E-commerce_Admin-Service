package com.app.AdminService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sub_admin_rule")
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Builder
public class SubAdminRule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ruleId", nullable = false, updatable = false, unique = true)
    private UUID ruleId;


    @OneToOne
    @JoinColumn(name = "sub_admin_id", nullable = false, unique = true)
    @JsonBackReference
    private SubAdmin subAdmin;

    @Column(name = "service")
    private String service;
    @Column(name = "canManageStore")
    private boolean canManageStore;
    @Column(name = "canManageOrders")
    private boolean canManageOrders;

    @Column(name = "canManageCustomers")
    private boolean canManageCustomers;

    @Column(name = "canManageInventory")
    private boolean canManageInventory;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;


    @PrePersist
    public void onPrePersist() {
        this.setCreateDate(LocalDateTime.now());
        this.setUpdateDate(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setUpdateDate(LocalDateTime.now());
    }



}
