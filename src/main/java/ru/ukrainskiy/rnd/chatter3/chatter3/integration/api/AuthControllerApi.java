package ru.ukrainskiy.rnd.chatter3.chatter3.integration.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.form.SignupForm;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;

@RequestMapping("/api/")
@Tag(name = "Authentication")
public interface AuthControllerApi {

    @PostMapping(path = "/v1/user/login", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<?> login(@RequestParam String username,
            @Parameter(schema = @Schema(type = "string", format = "password")) @RequestParam String password);
    
    @GetMapping(path = "/v1/user/logout")
    Result<?> logout();

    @PostMapping(path = "/v1/user/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<?> registerUser(@RequestBody SignupForm signupForm);
}
