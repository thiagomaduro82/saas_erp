package com.syscode.saas_erp.saas_admin.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.syscode.saas_erp.models.Permission;
import com.syscode.saas_erp.services.PermissionService;
import com.syscode.saas_erp.utils.Constant;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/permission")
public class PermissionController {

    private static Logger log = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private PermissionService permissionService;

    @Operation(summary = "Get permission by UUID")
    @GetMapping("/{uuid}")
    public ResponseEntity<Permission> getByUuid(@PathVariable("uuid") String uuid) {
        log.info("Get permission by UUID endpoint called");
        return ResponseEntity.ok().body(permissionService.getByUuid(uuid));
    }

    @Operation(summary = "Get all permissions")
    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions(Optional<Integer> pageNumber, Optional<Integer> pageSize) {
        log.info("Get all permissions endpoint called");
        // Set up pageable variable
        Pageable pageable;
        if (pageNumber.isPresent() && pageNumber.isPresent()) {
            pageable = PageRequest.of(pageNumber.orElse(Constant.INITIAL_PAGE), pageSize.get());
        } else {
            pageable = PageRequest.of(Constant.INITIAL_PAGE, Constant.PAGE_SIZE);
        }
        return ResponseEntity.ok().body(permissionService.getAllPermissions(pageable));
    }

    @Operation(summary = "Create a new permission")
    @PostMapping
    public ResponseEntity<Permission> createPermission(@Valid @RequestBody Permission permission) {
        log.info("Create permission endpoint called");
        return ResponseEntity.ok().body(permissionService.create(permission));
    }

    @Operation(summary = "Update the permission")
    @PutMapping("/{uuid}")
    public ResponseEntity<Permission> updatePermission(@PathVariable("uuid") String uuid, @Valid @RequestBody Permission permission) {
        log.info("Update permission endpoint called");
        return ResponseEntity.ok().body(permissionService.update(uuid, permission));
    }

    @Operation(summary = "Delete the permission")
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletePermission(@PathVariable("uuid") String uuid) {
        log.info("Delete permission endpoint called");
        permissionService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
    
}