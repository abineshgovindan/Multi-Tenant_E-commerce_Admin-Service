package com.app.AdminService.Service;

import com.app.AdminService.Dto.Mapper.SubAdminMapper;
import com.app.AdminService.Dto.Request.SubAdminRequest;
import com.app.AdminService.Dto.Response.AdminResponse;
import com.app.AdminService.Dto.Response.SubAdminResponse;
import com.app.AdminService.Dto.Response.SubAdminRuleResponse;
import com.app.AdminService.Entity.SubAdmin;
import com.app.AdminService.Entity.SubAdminRule;
import com.app.AdminService.Exception.AdminNotFoundException;
import com.app.AdminService.Exception.SubAdminNotFoundExpection;
import com.app.AdminService.Repository.SubAdminRepository;
import com.app.AdminService.Repository.SubAdminRuleRepository;
import com.app.AdminService.Service.ServiceImplement.SubAdminServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubAdminService implements SubAdminServiceImp {

    private final SubAdminRepository subAdminRepository;

    private final SubAdminRuleRepository subAdminRuleRepository;

    private final SubAdminMapper subAdminMapper;



    @Override
    public SubAdminResponse getSubAdminById(UUID subAdminId) {
        var subAdmin = subAdminRepository.findById(subAdminId).orElseThrow(()-> new SubAdminNotFoundExpection("Sub Admin not found"));
        if(subAdmin != null){
            SubAdminResponse response = subAdminMapper.fromSubAdmin(subAdmin);
            return response;
        }
        return null;
    }

    @Override
    public SubAdminRule getSubAdminRulesById(UUID subAdminId) {
     return subAdminRuleRepository.findRulesBySubAdminId(subAdminId);
    }

    @Override
    public String updateSubAdmin(UUID id, SubAdminRequest request) {
        return null;
    }

//    public SubAdminRuleResponse getSubAdminRulesById(UUID subAdminId){
//        SubAdminRule subAdminRule = subAdminRuleRepository.findBySubAdminId(subAdminId);
//
//
//
//        return null;
//    }
}
