package com.app.AdminService.Service.ServiceImplement;

import com.app.AdminService.Dto.Request.SubAdminCreateRequest;
import com.app.AdminService.Dto.Request.SubAdminRequest;
import com.app.AdminService.Dto.Request.adminRequest;
import com.app.AdminService.Dto.Response.AdminResponse;
import com.app.AdminService.Dto.Response.SubAdminCreateResponse;
import com.app.AdminService.Entity.SubAdmin;
import com.app.AdminService.Entity.SubAdminRule;

import java.util.UUID;

public interface AdminServiceImp {

    public String createAdmin(adminRequest request);

    public AdminResponse getAdminById(UUID id);

    public String updateAdmin(UUID id, adminRequest request);


    public String deleteAdmin(UUID id);

    public SubAdminCreateResponse createSubAdmin(UUID adminId, SubAdminCreateRequest request);
    public String updateSubAdmin(UUID adminId , UUID subAdminId, SubAdminRequest subAdmin);
    public String updateSubAdminRules(SubAdminRule subAdminRule, UUID subAdminId);
    public Boolean deleteSubAdmin(UUID adminId, UUID subAdminId);

    public Boolean canCreateStore(UUID adminId);

}
