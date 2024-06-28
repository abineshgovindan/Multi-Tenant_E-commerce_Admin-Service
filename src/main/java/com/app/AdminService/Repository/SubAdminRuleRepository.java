package com.app.AdminService.Repository;

import com.app.AdminService.Entity.SubAdminRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SubAdminRuleRepository extends JpaRepository<SubAdminRule, UUID> {
    //@Query("SELECT sar.* FROM SubAdminRule sar join SubAdmin sa on sa.sub_admin_id = sar.sub_admin_id where sa.sub_admin_id = :subAdminId")

    @Query("SELECT sar FROM SubAdminRule sar WHERE sar.subAdmin.id = :subAdminId")
    SubAdminRule findRulesBySubAdminId(@Param("subAdminId") UUID subAdminId);


}

