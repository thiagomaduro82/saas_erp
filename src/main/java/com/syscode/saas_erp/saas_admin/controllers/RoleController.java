package com.syscode.saas_erp.saas_admin.controllers;

import com.syscode.saas_erp.models.Role;
import com.syscode.saas_erp.services.RoleService;
import com.syscode.saas_erp.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/{uuid}")
  public ResponseEntity<Role> getByUuid(@PathVariable("uuid") String uuid) {
    log.info("Get role by UUID endpoint called");
    return ResponseEntity.ok().body(roleService.getRoleByUuid(uuid));
  }

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

}
