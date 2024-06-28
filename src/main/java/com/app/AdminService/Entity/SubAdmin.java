package com.app.AdminService.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "sub_admin",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_Email", columnNames = "Email" )

)
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Builder
public class SubAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sub_admin_id", nullable = false, updatable = false, unique = true)
    private UUID sub_admin_id;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
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


    @OneToOne(mappedBy = "subAdmin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference
    private SubAdminRule subAdminRule;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
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
