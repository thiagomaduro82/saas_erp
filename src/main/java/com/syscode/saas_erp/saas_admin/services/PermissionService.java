package com.syscode.saas_erp.saas_admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.syscode.saas_erp.saas_admin.models.Permission;
import com.syscode.saas_erp.saas_admin.repositories.PermissionRepository;
import com.syscode.saas_erp.utils.GenerateUuids;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission getByUuid(String uuid) {
        return permissionRepository.findByUuid(uuid).orElse(null);
    }

    public List<Permission> getAll(Pageable pageable) {
        return permissionRepository.findAll(pageable).toList();
    }

    public Permission create(Permission permission) {
        permission.setId(null);
        permission.setUuid(GenerateUuids.genUuid13());
        return permissionRepository.save(permission);
    }

    public Permission update(String uuid, Permission permission) {
        Permission updatedPermission = getByUuid(uuid);
        if (updatedPermission != null) {
            updatedPermission.setName(permission.getName());
            updatedPermission.setDescription(permission.getDescription());
            return permissionRepository.save(updatedPermission);
        }
        return null;
    }

    public void delete(String uuid) {
        Permission permission = getByUuid(uuid);
        if (permission != null) {
            permissionRepository.delete(permission);
        }
    }
    
}
