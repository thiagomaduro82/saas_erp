package com.syscode.saas_erp.saas_admin.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TB_ROLES")
public class Role extends BaseEntity {
    
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    @Length(min = 3, max = 127, message = "The NAME field must be between 3 and 127 characters")
    @NotNull(message = "The NAME field can't be null")
    private String name;

    public Role() {
        super();
    }

    public Role(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
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

}
