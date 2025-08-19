package com.vouchers.userservice.mapper;

import com.vouchers.common.enums.Role;
import com.vouchers.userservice.dto.CreateUserDTO;
import com.vouchers.userservice.dto.UpdateUserDTO;
import com.vouchers.userservice.dto.UserSearchResultDTO;
import com.vouchers.userservice.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", expression = "java(mapRole(createUserDTO.role().toString()))")
    User toUser(CreateUserDTO createUserDTO);

    UserSearchResultDTO toUserSearchResultDTO(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UpdateUserDTO dto, @MappingTarget User user);

    default Role mapRole(String value) {
        return value == null ? null : Role.valueOf(value);
    }
}
