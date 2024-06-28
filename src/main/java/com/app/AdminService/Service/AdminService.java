package com.app.AdminService.Service;

import com.app.AdminService.Dto.Mapper.AdminMapper;
import com.app.AdminService.Dto.Request.SubAdminCreateRequest;
import com.app.AdminService.Dto.Request.SubAdminRequest;
import com.app.AdminService.Dto.Request.adminRequest;
import com.app.AdminService.Dto.Response.AdminResponse;
import com.app.AdminService.Dto.Response.SubAdminCreateResponse;
import com.app.AdminService.Entity.Admin;
import com.app.AdminService.Entity.SubAdmin;
import com.app.AdminService.Entity.SubAdminRule;
import com.app.AdminService.Entity.UserRole;
import com.app.AdminService.Exception.AdminNotFoundException;
import com.app.AdminService.Exception.SubAdminNotFoundExpection;
import com.app.AdminService.Repository.AdminRepository;
import com.app.AdminService.Repository.SubAdminRepository;
import com.app.AdminService.Repository.SubAdminRuleRepository;
import com.app.AdminService.Service.ServiceImplement.AdminServiceImp;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService  implements AdminServiceImp {
    private final AdminRepository repository;
    private final SubAdminRepository subAdminRepository;
    private final SubAdminRuleRepository subAdminRuleRepository;
    private final AdminMapper adminMapper;

    @Override
    public String createAdmin(adminRequest request) {
        var admin = adminMapper.toAdmin(request);
        var savedUser = repository.save(admin);
        return String.valueOf(savedUser.getAdminId());

    }

    @Override
    public AdminResponse getAdminById(UUID adminId) {
        var admin = repository.findById(adminId).orElseThrow(()-> new AdminNotFoundException("Admin not found"));
        if(admin != null){
            AdminResponse response = adminMapper.fromAdmin(admin);
            return response;
        }

        return null;
    }

    @Override
    public String updateAdmin(UUID id, adminRequest request) {
            Admin admin = repository.findById(id).orElseThrow(() -> new AdminNotFoundException(
                    String.format("Cannot update customer:: No customer found with the provided ID: %s", request.getAdminId())
            ));
            if (admin != null) {
                mergeAdmin(admin, request);
                repository.save(admin);
                return "Admin updated successfully";
            }
            return "Admin not found";
        }
    private void mergeAdmin(Admin admin, adminRequest request){
    if(StringUtils.isNotBlank(request.getFirstName())){
        admin.setFirstName(request.getFirstName());
    }
    if(StringUtils.isNotBlank(request.getLastName())){
        admin.setLastName(request.getLastName());
    }
    if(StringUtils.isNotBlank(request.getEmail())){
        admin.setEmail(request.getEmail());
    }
    if (StringUtils.isNotBlank(request.getProfileUrl())){
        admin.setProfileUrl(request.getProfileUrl());
    }
    if(StringUtils.isNotBlank(request.getMobileNumber())){
        admin.setMobileNumber(request.getMobileNumber());
    }

    admin.setUpdateDate(LocalDateTime.now());

    }


    @Override
    public String deleteAdmin(UUID id) {
        Admin admin = repository.findById(id).orElse(null);
        if (admin != null) {
            repository.delete(admin);
            return "Admin deleted successfully";
        }
        return "Admin not found";
    }

    @Override
    @Transactional
    public SubAdminCreateResponse createSubAdmin(UUID adminId, SubAdminCreateRequest request) {
        var admin = repository.findById(adminId).orElseThrow(()-> new AdminNotFoundException("AdminId not found"));

        SubAdmin subAdmin = adminMapper.fromSubAdminRequest(request);
        subAdmin.setAdmin(admin);
        SubAdmin savedSubAdmin = subAdminRepository.save(subAdmin);
        SubAdminRule subAdminRule = adminMapper.fromSubAdminRuleRequest(request);
        subAdminRule.setSubAdmin(savedSubAdmin);
        SubAdminRule savedSubAdminRule = subAdminRuleRepository.save(subAdminRule);
        SubAdminCreateResponse subAdminCreateResponse = adminMapper.subAdminCreateResponse(savedSubAdmin, savedSubAdminRule);


        return subAdminCreateResponse;
    }

    @Override
    public String updateSubAdmin(UUID adminId , UUID subAdminId , SubAdminRequest subAdmin) {
        var admin = repository.findById(adminId).orElseThrow(()-> new AdminNotFoundException("AdminId not found"));
        var resultsubAdmin = subAdminRepository.findById(subAdminId).orElseThrow(()-> new AdminNotFoundException("SubAdmin not Found"));

        if(admin.getAdminId() != resultsubAdmin.getAdmin().getAdminId()){
            throw new SubAdminNotFoundExpection(  String.format("Cannot update SuBAdmin:: No SubAdmin found with the provided Admin ID: %s", adminId));
        }
        mergeSubAdmin(resultsubAdmin, subAdmin);

        return "SubAdmin Updated successfully";
    }

    private void mergeSubAdmin(SubAdmin subAdmin, SubAdminRequest request){
        if(StringUtils.isNotBlank(request.getFirstName())){
            subAdmin.setFirstName(request.getFirstName());
        }
        if(StringUtils.isNotBlank(request.getLastName())){
            subAdmin.setLastName(request.getLastName());
        }
        if(StringUtils.isNotBlank(request.getEmail())){
            subAdmin.setEmail(request.getEmail());
        }
        if (StringUtils.isNotBlank(request.getProfileUrl())){
            subAdmin.setProfileUrl(request.getProfileUrl());
        }
        if(StringUtils.isNotBlank(request.getMobileNumber())){
            subAdmin.setMobileNumber(request.getMobileNumber());
        }
        if(request.getUserRole() != UserRole.SUB_ADMIN){
            if(request.getUserRole() != UserRole.SUPER_ADMIN){
                subAdmin.setUserRole(UserRole.SUPER_ADMIN);
            }
        }

        subAdmin.setUpdateDate(LocalDateTime.now());

    }

    @Override
    public String updateSubAdminRules(SubAdminRule subAdminRule, UUID subAdminId) {
        return null;
    }

    @Override
    public Boolean deleteSubAdmin(UUID adminId, UUID subAdminId) {
        var admin = repository.findById(adminId).orElseThrow(()-> new AdminNotFoundException("AdminId not found"));
        var resultsubAdmin = subAdminRepository.findById(subAdminId).orElseThrow(()-> new AdminNotFoundException("SubAdmin not Found"));

        if(admin.getAdminId() == resultsubAdmin.getAdmin().getAdminId()){
            subAdminRepository.delete(resultsubAdmin);
           return true;
        }

        return false;

    }

    @Override
    public Boolean canCreateStore(UUID adminId) {
        Optional<Admin> admin = repository.findById(adminId);
        if(admin.isPresent()){
            Admin getAdmin = admin.get();
            if(getAdmin.getUserRole().equals(UserRole.ADMIN)){
                return true;
            }else {
                return false;
            }
        }

        return false;
    }

}


