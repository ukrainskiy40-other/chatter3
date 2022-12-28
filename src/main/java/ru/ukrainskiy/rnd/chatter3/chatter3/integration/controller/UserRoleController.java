package ru.ukrainskiy.rnd.chatter3.chatter3.integration.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.integration.api.UserRoleControllerApi;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserRoleDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter.UserRoleAdapter;

@RestController
@RequiredArgsConstructor
public class UserRoleController implements UserRoleControllerApi {
    
    private final UserRoleAdapter userRoleAdapter;

    @Override
    public List<UserRoleDto> getAllUserRole() {
        return userRoleAdapter.findAllUserRole();
    }

    @Override
    public UserRoleDto findUserRoleById(Long userRoleId) {
        return userRoleAdapter.findUserRoleById(userRoleId);
    }

    @Override
    public UserRoleDto createUserRole(String roleName) {
        return userRoleAdapter.createUserRole(roleName);
    }

    @Override
    public void deleteUserRole(Long userRoleId) {
        userRoleAdapter.deleteUserRoleById(userRoleId);
    }

}
