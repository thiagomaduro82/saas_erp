package com.syscode.saas_erp.saas_admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syscode.saas_erp.models.Permission;
import com.syscode.saas_erp.services.PermissionService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/v1/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Operation(summary = "Get permission by UUID")
    @GetMapping("/{uuid}")
    public ResponseEntity<Permission> getByUuid(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok().body(permissionService.getByUuid(uuid));
    }
    
}
