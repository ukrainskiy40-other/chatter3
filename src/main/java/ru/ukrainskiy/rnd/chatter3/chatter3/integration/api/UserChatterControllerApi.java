package ru.ukrainskiy.rnd.chatter3.chatter3.integration.api;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserChatterDto;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;


@RequestMapping("/api/v1/front/users-chatter")
@Tag(name = "users-chatter")
@Secured({"ROLE_USER"})
public interface UserChatterControllerApi {

    @GetMapping
    Result<List<UserChatterDto>> findAllUserChatter();

    @PostMapping(path = "/activated/{userId}")
    @Secured({"ROLE_ADMIN"})
    Result<?> setUserChatterActivated(@PathVariable Long userId);
    
}
