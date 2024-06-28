package com.app.AdminService.Controller;

import com.app.AdminService.Dto.Response.AdminResponse;
import com.app.AdminService.Dto.Response.SubAdminResponse;
import com.app.AdminService.Dto.Response.SubAdminRuleResponse;
import com.app.AdminService.Entity.SubAdmin;
import com.app.AdminService.Entity.SubAdminRule;
import com.app.AdminService.Service.ServiceImplement.SubAdminServiceImp;
import com.app.AdminService.Service.SubAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/subAdmin")
@RequiredArgsConstructor
public class SubAdminController {
    private final SubAdminServiceImp subAdminService;

    @GetMapping("/{id}")
    public ResponseEntity<SubAdminResponse> getSubAdminById(@PathVariable UUID id) {
        SubAdminResponse subAdmin = subAdminService.getSubAdminById(id);
        if (subAdmin != null) {
            return ResponseEntity.ok(subAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{subAdminId}/rules")
    public ResponseEntity<SubAdminRule> getSubAdminRulesById(@PathVariable UUID subAdminId) {
        SubAdminRule subAdmin = subAdminService.getSubAdminRulesById(subAdminId);
        if (subAdmin != null) {
            return ResponseEntity.ok(subAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }

    }




}
