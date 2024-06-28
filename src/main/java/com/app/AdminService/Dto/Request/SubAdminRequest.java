package com.app.AdminService.Dto.Request;

import com.app.AdminService.Entity.Admin;
import com.app.AdminService.Entity.SubAdminRule;
import com.app.AdminService.Entity.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class SubAdminRequest {


    private UUID adminId;

    @NotBlank(message = "Enter the valid First Name .")
    private String firstName;

    @NotBlank(message = "Enter the valid Last Name.")
    private String lastName;

    @Email(message = "Email is not valid")
    private String email;


    private String profileUrl;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String mobileNumber;

    private UserRole userRole;

}
