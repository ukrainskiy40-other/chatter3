package ru.ukrainskiy.rnd.chatter3.chatter3.integration.api;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.MessageUserChatterViewDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.form.MessageChatterForm;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;

@RequestMapping("/api/v1/front/messages-chatter")
@Tag(name = "messages-chatter")
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public interface MessageUserChatterApi {

    @GetMapping("/only-my-messages")
    Result<List<MessageUserChatterViewDto>> findAllMyMessage();

    @PostMapping
    Result<MessageUserChatterViewDto> sendNewMessage(MessageChatterForm form);
    
}
