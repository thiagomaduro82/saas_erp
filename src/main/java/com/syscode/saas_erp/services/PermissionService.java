package com.syscode.saas_erp.services;

import com.syscode.saas_erp.exceptions.ObjectNotFoundException;
import com.syscode.saas_erp.models.Permission;
import com.syscode.saas_erp.repositories.PermissionRepository;
import com.syscode.saas_erp.utils.GenerateUuids;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Permission getByUuid(String uuid) {
        return permissionRepository.findByUuid(uuid).orElseThrow(() -> new ObjectNotFoundException("Permission not found - UUID: " + uuid));
    }

    public List<Permission> getAllPermissions(Pageable pageable) {
        return permissionRepository.findAll(pageable).toList();
    }

    public Permission create(Permission permission) {
        permission.setId(null);
        permission.setUuid(GenerateUuids.genUuid13());
        return permissionRepository.save(permission);
    }

    public Permission update(String uuid, Permission permission) {
        Permission updatedPermission = getByUuid(uuid);
        updatedPermission.setName(permission.getName());
        updatedPermission.setDescription(permission.getDescription());
        return permissionRepository.save(updatedPermission);
    }

    public void delete(String uuid) {
        Permission permission = getByUuid(uuid);
        permissionRepository.delete(permission);
    }
    
}
