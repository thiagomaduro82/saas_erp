package com.syscode.saas_erp.models.request;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class PermissionReqDTO {
    
    @Column(name = "name")
    @Length(min = 3, max = 127, message = "The NAME field must contain between 3 and 127 characters")
    @NotNull
    private String name;

    @Column(name = "description")
    @Length(min = 3, max = 255, message = "The NAME field must contain between 3 and 255 characters")
    @NotNull
    private String description;

    public PermissionReqDTO() {
        super();
    }

    public PermissionReqDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
