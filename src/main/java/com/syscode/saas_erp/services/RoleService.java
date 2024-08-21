package com.syscode.saas_erp.services;

import com.syscode.saas_erp.exceptions.ObjectNotFoundException;
import com.syscode.saas_erp.models.Role;
import com.syscode.saas_erp.repositories.RoleRepository;
import com.syscode.saas_erp.utils.GenerateUuids;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

  private final RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public Role getRoleByUuid(String uuid) {
    return roleRepository.findByUuid(uuid).orElseThrow(() -> new ObjectNotFoundException("Role not found - UUID: " + uuid));
  }

  public Page<Role> getAllRoles(Pageable pageable) {
    return roleRepository.findAll(pageable);
  }

  public Role create(Role role) {
    role.setId(null);
    role.setUuid(GenerateUuids.genUuid13());
    return roleRepository.save(role);
  }

  public Role update(String uuid, Role role) {
    Role updatedRole = getRoleByUuid(uuid);
    updatedRole.setName(role.getName());
    return roleRepository.save(updatedRole);
  }

  public void delete(String uuid) {
    Role role = getRoleByUuid(uuid);
    roleRepository.delete(role);
  }

}
