package com.syscode.saas_erp.models.request;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class RoleReqDTO {

  @Length(min = 3, max = 127, message = "The NAME field must contain between 3 and 127 characters")
  @NotNull
  private String name;

  public RoleReqDTO() {
    super();
  }

  public RoleReqDTO(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
