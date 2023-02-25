package ru.ukrainskiy.rnd.chatter3.chatter3.integration.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.integration.api.UserChatterControllerApi;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserChatterDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter.UserChatterAdapter;

@RestController
@RequiredArgsConstructor
public class UserChatterController extends AbstractController implements UserChatterControllerApi {

    private final UserChatterAdapter adapter;

    @Override
    public Result<List<UserChatterDto>> findAllUserChatter() {
        return super.result(adapter::findAllUserChatter);
    }

    @Override
    public Result<?> setUserChatterActivated(@NotNull Long userId) {
        return super.result(adapter::setActive, userId);
    }
    
}
