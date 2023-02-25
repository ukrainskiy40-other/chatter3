package ru.ukrainskiy.rnd.chatter3.chatter3.integration.api;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserRoleDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;


@RequestMapping("/api/v1/front/users-role")
@Tag(name = "users-role")
@Secured("ROLE_ADMIN")
public interface UserRoleControllerApi {
    
    @GetMapping
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    Result<List<UserRoleDto>> getAllUserRole();

    @GetMapping("{userRoleId}")
    Result<UserRoleDto> findUserRoleById(@PathVariable Long userRoleId);

    @PostMapping
    Result<UserRoleDto> createUserRole(@RequestParam String roleName);

    @DeleteMapping
    Result<?> deleteUserRole(@RequestParam Long userRoleId);
    
}
