package ru.ukrainskiy.rnd.chatter3.chatter3.integration.api;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserChatterDto;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/api/v1/front/users-chatter")
@Tag(name = "users-chatter")
// @PreAuthorize("isAuthenticated()")
@Secured({"USER_USER"})
public interface UserChatterControllerApi {

    @GetMapping
    List<UserChatterDto> findAllUserChatter();

    @PostMapping(path = "/activated/{userId}")
    @Secured({"ROLE_ADMIN"})
    void setUserChatterActivated(@PathVariable Long userId);
    
}
