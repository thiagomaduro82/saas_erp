package com.syscode.saas_erp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "role_permissions")
public class RolePermission extends BaseEntity {

  @Column(name = "role_id")
  @NotNull
  private Long roleId;

  @Column(name = "permission_id")
  @NotNull
  private Long permissionId;

  public RolePermission() {
    super();
  }

  public RolePermission(Long roleId, Long permissionId) {
    this.roleId = roleId;
    this.permissionId = permissionId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
  }
}
