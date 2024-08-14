package com.syscode.saas_erp.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {
    
    @Column(name = "uuid")
    @NotNull
    private String uuid;

    @Column(name = "name")
    @Length(min = 3, max = 127, message = "The NAME field must contain between 3 and 127 characters")
    @NotNull
    private String name;

    @Column(name = "description")
    @Length(min = 3, max = 255, message = "The NAME field must contain between 3 and 255 characters")
    @NotNull
    private String description;

    public Permission() {
        super();
    }

    public Permission(String uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
