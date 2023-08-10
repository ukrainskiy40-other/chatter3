package ru.ukrainskiy.rnd.chatter3.chatter3.model.form;

import jakarta.validation.constraints.NotNull;

public record MessageChatterForm(
    @NotNull String message,
    Long returnMessageId
) {
    
    public MessageChatterForm {}
}
