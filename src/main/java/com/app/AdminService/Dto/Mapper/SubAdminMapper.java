package com.app.AdminService.Dto.Mapper;

import com.app.AdminService.Dto.Response.SubAdminResponse;
import com.app.AdminService.Entity.SubAdmin;
import org.springframework.stereotype.Component;

@Component
public class SubAdminMapper {

    public SubAdminResponse fromSubAdmin(SubAdmin subAdmin){
        if(subAdmin == null){
            return null;
        }
        return SubAdminResponse.builder()
                .subAdminId(subAdmin.getSub_admin_id())
                .adminId(subAdmin.getAdmin().getAdminId())
                .firstName(subAdmin.getFirstName())
                .lastName(subAdmin.getLastName())
                .email(subAdmin.getEmail())
                .mobileNumber(subAdmin.getEmail())
                .profileUrl(subAdmin.getProfileUrl())
                .createDate(subAdmin.getCreateDate())
                .updateDate(subAdmin.getUpdateDate())
                .userRole(subAdmin.getUserRole())
                .build();
    }
}
