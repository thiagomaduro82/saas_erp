package com.syscode.saas_erp.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

  @Column(name = "uuid")
  @NotNull
  private String uuid;

  @Column(name = "name")
  @Length(min = 3, max = 127, message = "The NAME field must contain between 3 and 127 characters")
  @NotNull
  private String name;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name = "role_permissions", joinColumns = {@JoinColumn(name = "role_id")},
  inverseJoinColumns = {@JoinColumn(name = "permission_id")})
  private Set<Permission> permissions = new HashSet<>();

  public Role() {
    super();
  }

  public Role(String uuid, String name, Set<Permission> permissions) {
    this.uuid = uuid;
    this.name = name;
    this.permissions = permissions;
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

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<Permission> permissions) {
    this.permissions = permissions;
  }

}
