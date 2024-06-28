package com.app.AdminService.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubAdminRuleResponse {
    private UUID ruleId;
    private String service;
    private boolean canManageStore;
    private boolean canManageOrders;
    private boolean canManageInventory;
    private boolean canManageCustomers;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;



}
