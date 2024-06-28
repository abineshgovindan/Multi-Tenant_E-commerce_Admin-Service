package com.app.AdminService.Dto.Request;

import com.app.AdminService.Entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class adminRequest {
    private UUID adminId;

    @NotBlank(message = "Enter the valid First Name .")
    private String firstName;

    @NotBlank(message = "Enter the valid Last Name.")
    private String lastName;

    @Email(message = "Email is not valid")
    private String email;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String mobileNumber;



    private String profileUrl;


    private UserRole userRole;
}
