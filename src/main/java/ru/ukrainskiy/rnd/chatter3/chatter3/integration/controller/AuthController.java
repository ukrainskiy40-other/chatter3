package ru.ukrainskiy.rnd.chatter3.chatter3.integration.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.integration.api.AuthControllerApi;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.form.SignupForm;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter.UserChatterAdapter;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthControllerApi {

    private final UserChatterAdapter userChatterAdapter;

    @Override
    public Result<?> login(String username, String password) {
        Exception exception = new IllegalStateException("Add spring Security to handle authentication");
        return Result.error(exception.getClass().toString(), exception.getMessage());
    }

    @Override
    public Result<?> logout() {
        Exception exception = new IllegalStateException("Add spring Security to handle authentication");
        return Result.error(exception.getClass().toString(), exception.getMessage());
    }

    @Override
    public Result<?> registerUser(@NotNull SignupForm signupForm) {
        userChatterAdapter.registerUserChatter(signupForm);
        Result<String> result = new Result<>("User registered successfully!");
        return result;
    }
}
