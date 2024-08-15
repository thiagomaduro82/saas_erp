package com.syscode.saas_erp.models.mapper;

import com.syscode.saas_erp.models.User;
import com.syscode.saas_erp.models.request.UserAddReqDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  User userAddReqDTOToUser(UserAddReqDTO userAddReqDTO, @MappingTarget User user);

}
