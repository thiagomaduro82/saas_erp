package com.syscode.saas_erp.services;

import com.syscode.saas_erp.exceptions.ObjectNotFoundException;
import com.syscode.saas_erp.models.RolePermission;
import com.syscode.saas_erp.repositories.RolePermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {

  private final RolePermissionRepository rolePermissionRepository;

  public RolePermissionService(RolePermissionRepository rolePermissionRepository) {
    this.rolePermissionRepository = rolePermissionRepository;
  }

  public RolePermission getById(Long id) {
    return rolePermissionRepository
        .findById(id).orElseThrow(() -> new ObjectNotFoundException("Role Permission not found - ID: " + id));
  }

  public RolePermission create(RolePermission rolePermission) {
    rolePermission.setId(null);
    return rolePermissionRepository.save(rolePermission);
  }

  public void delete(Long id) {
    RolePermission rolePermission = getById(id);
    rolePermissionRepository.delete(rolePermission);
  }

}
