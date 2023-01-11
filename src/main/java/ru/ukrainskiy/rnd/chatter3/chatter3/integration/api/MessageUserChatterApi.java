package ru.ukrainskiy.rnd.chatter3.chatter3.integration.api;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.MessageUserChatterViewDto;

@RequestMapping("/api/v1/front/messages-chatter")
@Tag(name = "messages-chatter")
@Secured({"ROLE_USER"})
public interface MessageUserChatterApi {

    @GetMapping("/only-my-messages")
    List<MessageUserChatterViewDto> findAllMyMessage();
    
}
