package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserRoleDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.EntityNotFoundException;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.mapper.UserRoleMapper;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade.UserRoleFacade;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRoleAdapter {

    private final UserRoleFacade facade;
    private final UserRoleMapper mapper;
    
    public List<UserRoleDto> findAllUserRole() {
        return mapper.toListDto(facade.findAll());
    }

    public UserRoleDto findUserRoleById(Long userRoleId) {
        var entityOpt = facade.findById(userRoleId);
        if (entityOpt.isEmpty()) {
            throw new EntityNotFoundException("UserRole by id not found.");
        }
        return mapper.toDto(entityOpt.get());
    }

    public UserRoleDto createUserRole(String role) {
        return mapper.toDto(facade.create(role));
    }

    public void deleteUserRoleById(Long userRoleId) {
        facade.deleteById(userRoleId);
    }
}
