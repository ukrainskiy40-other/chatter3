package ru.ukrainskiy.rnd.chatter3.chatter3.integration.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.integration.api.UserRoleControllerApi;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserRoleDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter.UserRoleAdapter;

@RestController
@RequiredArgsConstructor
public class UserRoleController extends AbstractController implements UserRoleControllerApi {
    
    private final UserRoleAdapter userRoleAdapter;

    @Override
    public Result<List<UserRoleDto>> getAllUserRole() {
        return super.result(userRoleAdapter::findAllUserRole);
    }

    @Override
    public Result<UserRoleDto> findUserRoleById(Long userRoleId) {
        return super.result(userRoleAdapter::findUserRoleById, userRoleId);
    }

    @Override
    public Result<UserRoleDto> createUserRole(String roleName) {
        return super.result(userRoleAdapter::createUserRole, roleName);
    }

    @Override
    public Result<?> deleteUserRole(Long userRoleId) {
        return super.result(userRoleAdapter::deleteUserRoleById, userRoleId);
    }

}
