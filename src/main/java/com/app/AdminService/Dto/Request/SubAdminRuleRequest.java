package com.app.AdminService.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class SubAdminRuleRequest {
    private UUID ruleId;

    private String service;

    private boolean canManageStore;

    private boolean canManageOrders;

    private boolean canManageInventory;

    private boolean canManageCustomers;

}
