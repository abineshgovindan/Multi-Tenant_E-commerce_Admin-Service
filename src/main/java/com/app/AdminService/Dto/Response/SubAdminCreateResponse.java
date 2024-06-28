package com.app.AdminService.Dto.Response;

import com.app.AdminService.Entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubAdminCreateResponse {
    private UUID subAdminId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String profileUrl;
    private UserRole userRole;

    private SubAdminRuleResponse subAdminRules;







}
