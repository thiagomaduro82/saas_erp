package com.syscode.saas_erp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public Permission() {
        super();
    }

    public Permission(String uuid, String name, String description, Set<Role> roles) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.roles = roles;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
