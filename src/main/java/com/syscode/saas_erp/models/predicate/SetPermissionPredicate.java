package com.syscode.saas_erp.models.predicate;

import com.querydsl.core.BooleanBuilder;
import com.syscode.saas_erp.models.QPermission;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Builder
@Getter
@Setter
public class SetPermissionPredicate {

  private Optional<String> uuid;
  private Optional<String> name;
  private Optional<String> description;

  public BooleanBuilder toPredicate() {
    QPermission qPermission = QPermission.permission;
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    uuid.ifPresent(val -> booleanBuilder.and(qPermission.uuid.like(val)));
    name.ifPresent(val -> booleanBuilder.and(qPermission.name.like(val)));
    description.ifPresent(val -> booleanBuilder.and(qPermission.description.like(val)));
    return booleanBuilder;
  }

}
