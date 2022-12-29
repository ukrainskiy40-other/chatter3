package ru.ukrainskiy.rnd.chatter3.chatter3.integration.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.integration.api.UserChatterControllerApi;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserChatterDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter.UserChatterAdapter;

@RestController
@RequiredArgsConstructor
public class UserChatterController implements UserChatterControllerApi {

    private final UserChatterAdapter adapter;

    public List<UserChatterDto> findAllUserChatter() {
        return adapter.findAllUserChatter();
    }
    
}