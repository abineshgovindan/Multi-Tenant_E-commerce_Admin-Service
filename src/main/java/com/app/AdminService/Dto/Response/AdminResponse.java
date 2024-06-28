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
public class AdminResponse {
    private UUID adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String profileUrl;
    private String mobileNumber;
    private UserRole userRole;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
