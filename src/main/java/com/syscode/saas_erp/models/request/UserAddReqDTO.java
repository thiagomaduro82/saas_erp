package com.syscode.saas_erp.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserAddReqDTO {

  @Length(min = 3, max = 127, message = "The NAME field must contain between 3 and 127 characters")
  @NotNull
  private String name;
  @Length(min = 3, max = 127, message = "The EMAIL field must contain between 3 and 255 characters")
  @NotNull
  @Email
  private String email;
  @Length(min = 6, message = "The PASSWORD field must be at least 6 characters long")
  @NotNull
  private String password;
  @NotNull
  private Long roleId;

  public UserAddReqDTO() {
    super();
  }

  public UserAddReqDTO(String name, String email, String password, Long roleId) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
}
