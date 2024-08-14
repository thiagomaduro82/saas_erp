package com.syscode.saas_erp.models.mapper;

import com.syscode.saas_erp.models.Role;
import com.syscode.saas_erp.models.request.RoleReqDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

  RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Role roleReqDtoToRole(RoleReqDTO roleReqDTO, @MappingTarget Role role);

}
