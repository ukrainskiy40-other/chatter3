package ru.ukrainskiy.rnd.chatter3.chatter3.integration.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.integration.api.MessageUserChatterApi;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.MessageUserChatterViewDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter.MessageUserChatterAdapter;

@RestController
@RequiredArgsConstructor
public class MessageUserChatterController implements MessageUserChatterApi {
    
    private final MessageUserChatterAdapter adapter;
    
    public List<MessageUserChatterViewDto> findAllMyMessage() {
        return adapter.findAllMessageByUserId();
    }
}