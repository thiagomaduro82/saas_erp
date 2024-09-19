package com.syscode.saas_erp.repositories;

import com.syscode.saas_erp.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>, QuerydslPredicateExecutor<Permission> {

    Optional<Permission> findByUuid(String uuid);
    
}
