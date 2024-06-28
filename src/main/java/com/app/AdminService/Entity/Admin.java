package com.app.AdminService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.*;

@Data
@Entity
@Table(name = "admin",
        uniqueConstraints = @UniqueConstraint (
                name = "unique_Email", columnNames = "Email" )

)
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "admin_id", nullable = false, updatable = false, unique = true)
    private UUID adminId;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "adminProfile")
    private String profileUrl;

    @Column(name = "mobileNumber")
    private String mobileNumber;
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
//    private List<AdminSubscription> subscriptions;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<SubAdmin> subAdmins;

//    @ManyToOne
//    @JoinColumn(name = "admin_parent_id")
//    private Admin parentAdmin;

//    @OneToMany(mappedBy = "adminId", cascade = CascadeType.ALL)
//    private List<SubAdminRule> subAdminRules;

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
