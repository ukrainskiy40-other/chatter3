package ru.ukrainskiy.rnd.chatter3.chatter3.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserChatterDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserRoleDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserChatterEntity;

@Mapper(componentModel = "spring")
public abstract class UserChatterMapper {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Mapping(target = "UserChatterDto.userRole", expression = "java(getUserRole(entity))")
    public abstract UserChatterDto toDto(UserChatterEntity entity);

    public abstract List<UserChatterDto> toListDto(List<UserChatterEntity> entities);

    protected UserRoleDto getUserRole(UserChatterEntity entity) {
        return userRoleMapper.toDto(entity.getUserRole());
    }
    
}
