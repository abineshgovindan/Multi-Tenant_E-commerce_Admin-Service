package com.app.AdminService.Repository;

import com.app.AdminService.Entity.SubAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubAdminRepository extends JpaRepository<SubAdmin, UUID> {

//    @Query("SELECT s FROM SubAdmin s LEFT JOIN FETCH s.subAdminRule WHERE s.subAdminId = :subAdminId")
//    Optional<SubAdmin> findSubAdminWithRulesById(UUID subAdminId);
}
