package ru.ukrainskiy.rnd.chatter3.chatter3.model.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserRoleDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserRoleEntity;


@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleDto toDto(UserRoleEntity entity);

    Set<UserRoleDto> toSetDto(Set<UserRoleEntity> entities);

    List<UserRoleDto> toListDto(List<UserRoleEntity> entities);
    
}
