package ru.ukrainskiy.rnd.chatter3.chatter3.model.form;

import jakarta.validation.constraints.NotBlank;

public record SignupForm(
        @NotBlank String username,
        @NotBlank String fullName,
        @NotBlank String password,
        @NotBlank String email) {
    public SignupForm {}
}
