package com.syscode.saas_erp.saas_admin.controllers;

import com.syscode.saas_erp.models.RolePermission;
import com.syscode.saas_erp.services.RolePermissionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/role-permission")
public class RolePermissionController {

  private static final Logger log = LoggerFactory.getLogger(RolePermissionController.class);

  private final RolePermissionService rolePermissionService;

  public RolePermissionController(RolePermissionService rolePermissionService) {
    this.rolePermissionService = rolePermissionService;
  }

  @Operation(summary = "Create a new role permission")
  @PostMapping
  public ResponseEntity<RolePermission> createRolePermission(@Valid @RequestBody RolePermission rolePermission) {
    log.info("Create role permission endpoint called");
    return ResponseEntity.ok().body(rolePermissionService.create(rolePermission));
  }

  @Operation(summary = "Delete a role permission")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRolePermission(@PathVariable("id") Long id) {
    log.info("Delete role permission endpoint called");
    rolePermissionService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
