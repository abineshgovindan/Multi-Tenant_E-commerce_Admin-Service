package com.app.AdminService.Dto.Mapper;

import com.app.AdminService.Dto.Request.SubAdminCreateRequest;
import com.app.AdminService.Dto.Request.SubAdminRequest;
import com.app.AdminService.Dto.Request.adminRequest;
import com.app.AdminService.Dto.Response.AdminResponse;
import com.app.AdminService.Dto.Response.SubAdminCreateResponse;
import com.app.AdminService.Dto.Response.SubAdminRuleResponse;
import com.app.AdminService.Entity.Admin;
import com.app.AdminService.Entity.SubAdmin;
import com.app.AdminService.Entity.SubAdminRule;
import com.app.AdminService.Entity.UserRole;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AdminMapper {
    public Admin toAdmin(adminRequest request){
        if(request == null){
            return null;
        }
        return  Admin.builder()
                .firstName(request.getFirstName())
                .lastName(request.getFirstName())
                .email(request.getEmail())
                .profileUrl(request.getProfileUrl())
                .userRole(UserRole.ADMIN)
                .mobileNumber(request.getMobileNumber())
                .build();

    }

    public AdminResponse fromAdmin(Admin admin){
        if(admin == null){
            return null;
        }
        return AdminResponse.builder()
                .adminId(admin.getAdminId())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .profileUrl(admin.getProfileUrl())
                .mobileNumber(admin.getMobileNumber())
                .userRole(admin.getUserRole())
                .updateDate(admin.getUpdateDate())
                .createDate(admin.getCreateDate())
                .build();
    }


//    private String firstName;
//    private String lastName;
//    private String email;
//    private String mobileNumber;
//    private String profileUrl;
//    private UserRole userRole;
//
//    private String service;
//    private boolean canManageStore;
//    private boolean canManageOrders;
//    private boolean canManageInventory;
//    private boolean canManageCustomers;
//    private LocalDateTime createDate;
//    private LocalDateTime updateDate;

    public SubAdmin fromSubAdminRequest(SubAdminCreateRequest request){
        return SubAdmin.builder()

                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .mobileNumber(request.getMobileNumber())
                .profileUrl(request.getProfileUrl())
                .userRole(UserRole.SUB_ADMIN)
                .build();
    }
    public SubAdminRule fromSubAdminRuleRequest(SubAdminCreateRequest request){
        return SubAdminRule.builder()
                .service(request.getSubAdminRules().getService())
                .canManageStore(request.getSubAdminRules().isCanManageStore())
                .canManageCustomers(request.getSubAdminRules().isCanManageCustomers())
                .canManageOrders(request.getSubAdminRules().isCanManageOrders())
                .canManageInventory(request.getSubAdminRules().isCanManageInventory())
                .build();

    }



    public SubAdminCreateResponse subAdminCreateResponse( SubAdmin subAdmin, SubAdminRule subAdminRule){
        if (subAdmin == null){
            return null;
        }
        if (subAdminRule == null){
            return null;
        }

        return SubAdminCreateResponse.builder().
                subAdminId(subAdmin.getSub_admin_id())
                .firstName(subAdmin.getFirstName())
                .lastName(subAdmin.getLastName())
                .email(subAdmin.getEmail())
                .mobileNumber(subAdmin.getMobileNumber())
                .profileUrl(subAdmin.getProfileUrl())
                .userRole(subAdmin.getUserRole())
                .subAdminRules(SubAdminRuleResponse.builder()
                        .service(subAdminRule.getService())
                        .canManageStore(subAdminRule.isCanManageStore())
                        .canManageCustomers(subAdminRule.isCanManageCustomers())
                        .canManageInventory(subAdminRule.isCanManageInventory())
                        .canManageOrders(subAdminRule.isCanManageOrders())
                        .createDate(subAdminRule.getCreateDate())
                        .updateDate(subAdminRule.getUpdateDate())
                        .build())
                .build();

    }


}
