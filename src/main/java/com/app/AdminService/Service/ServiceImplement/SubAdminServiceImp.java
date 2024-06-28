package com.app.AdminService.Service.ServiceImplement;


import com.app.AdminService.Dto.Request.SubAdminRequest;
import com.app.AdminService.Dto.Request.adminRequest;
import com.app.AdminService.Dto.Response.AdminResponse;
import com.app.AdminService.Dto.Response.SubAdminResponse;
import com.app.AdminService.Dto.Response.SubAdminRuleResponse;
import com.app.AdminService.Entity.SubAdmin;
import com.app.AdminService.Entity.SubAdminRule;

import java.util.Optional;
import java.util.UUID;

public interface SubAdminServiceImp {

   public SubAdminResponse getSubAdminById(UUID id);
   public SubAdminRule getSubAdminRulesById(UUID subAdminId);

   public String updateSubAdmin(UUID id, SubAdminRequest request);



}
