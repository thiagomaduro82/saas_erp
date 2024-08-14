package com.syscode.saas_erp.models.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.syscode.saas_erp.models.Permission;
import com.syscode.saas_erp.models.request.PermissionReqDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionMapper {
    
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Permission permissionReqDtoToPermission(PermissionReqDTO permissionReqDTO, @MappingTarget Permission permission);

}
