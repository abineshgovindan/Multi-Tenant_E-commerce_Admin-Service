package com.app.AdminService.Controller;

import com.app.AdminService.Dto.Request.SubAdminCreateRequest;
import com.app.AdminService.Dto.Request.SubAdminRequest;
import com.app.AdminService.Dto.Request.adminRequest;
import com.app.AdminService.Dto.Response.AdminResponse;
import com.app.AdminService.Dto.Response.SubAdminCreateResponse;
import com.app.AdminService.Entity.SubAdmin;
import com.app.AdminService.Service.ServiceImplement.AdminServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminServiceImp service;

    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody  @Valid adminRequest request){
        return ResponseEntity.ok(service.createAdmin(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> getAdminById(@PathVariable UUID id) {
        AdminResponse admin = service.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable UUID id, @RequestBody @Valid adminRequest request) {
        String result = service.updateAdmin(id, request);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable UUID id) {
        String result = service.deleteAdmin(id);
        if (result.equals("Admin deleted successfully")) {
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/{adminId}/sub-admin")
    public ResponseEntity<SubAdminCreateResponse> createSubAdmin(@PathVariable UUID adminId, @RequestBody @Valid SubAdminCreateRequest request){
        return ResponseEntity.ok(service.createSubAdmin(adminId, request));
    }

    @PutMapping("/{adminId}/sub-admin/{subAdminId}")
    public ResponseEntity<String> updateSubAdmin(@PathVariable UUID adminId, @PathVariable UUID subAdminId ,@RequestBody @Valid SubAdminRequest request) {

        String result = service.updateSubAdmin(adminId,subAdminId, request);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{adminId}/sub-admin/{subAdminId}")
    public ResponseEntity<String> deleteSubAdmin( UUID adminId, @PathVariable UUID subAdminId) {
        Boolean result = service.deleteSubAdmin(adminId, subAdminId);
        if (result) {
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/canCreateStore/{adminId}")
    public ResponseEntity<Boolean> canCreateStore(@PathVariable  UUID adminId){
        Boolean isadmin =service.canCreateStore(adminId);
        if (isadmin){
            return ResponseEntity.ok(isadmin);
        }
        return  ResponseEntity.ok(isadmin);
    }




}
