package com.syscode.saas_erp.saas_admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syscode.saas_erp.saas_admin.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
