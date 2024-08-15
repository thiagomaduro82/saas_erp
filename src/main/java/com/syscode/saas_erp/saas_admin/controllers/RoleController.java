package com.syscode.saas_erp.saas_admin.controllers;

import com.syscode.saas_erp.models.Role;
import com.syscode.saas_erp.models.mapper.RoleMapper;
import com.syscode.saas_erp.models.request.RoleReqDTO;
import com.syscode.saas_erp.services.RoleService;
import com.syscode.saas_erp.utils.Constant;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/role")
public class RoleController {

  private static final Logger log = LoggerFactory.getLogger(RoleController.class);

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @Operation(summary = "Get role by UUID")
  @GetMapping("/{uuid}")
  public ResponseEntity<Role> getByUuid(@PathVariable("uuid") String uuid) {
    log.info("Get role by UUID endpoint called");
    return ResponseEntity.ok().body(roleService.getRoleByUuid(uuid));
  }

  @Operation(summary = "Get all roles")
  @GetMapping
  public ResponseEntity<List<Role>> getAllRoles(Optional<Integer> pageNumber, Optional<Integer> pageSize) {
    log.info("Get all roles endpoint called");
    // Set up pageable variable
    Pageable pageable;
    if (pageNumber.isPresent() && pageSize.isPresent()) {
      pageable = PageRequest.of(pageNumber.orElse(Constant.INITIAL_PAGE), pageSize.get());
    } else {
      pageable = PageRequest.of(Constant.INITIAL_PAGE, Constant.PAGE_SIZE);
    }
    return ResponseEntity.ok().body(roleService.getAllRoles(pageable));
  }

  @Operation(summary = "Create a new role")
  @PostMapping
  public ResponseEntity<Role> createRole(@Valid @RequestBody RoleReqDTO roleReqDTO) {
    log.info("Create role endpoint called");
    Role role = new Role();
    role = RoleMapper.INSTANCE.roleReqDtoToRole(roleReqDTO, role);
    return ResponseEntity.ok().body(roleService.create(role));
  }

  @Operation(summary = "Update a role")
  @PutMapping("/{uuid}")
  public ResponseEntity<Role> updateRole(@PathVariable("uuid") String uuid, @Valid @RequestBody RoleReqDTO roleReqDTO) {
    log.info("Update role endpoint called");
    Role role = new Role();
    role = RoleMapper.INSTANCE.roleReqDtoToRole(roleReqDTO, role);
    return ResponseEntity.ok().body(roleService.update(uuid, role));
  }

  @Operation(summary = "Delete a role")
  @DeleteMapping("/{uuid}")
  public ResponseEntity<Void> deleteRole(@PathVariable("uuid") String uuid) {
    log.info("Delete role endpoint called");
    roleService.delete(uuid);
    return ResponseEntity.noContent().build();
  }

}
