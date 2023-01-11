package ru.ukrainskiy.rnd.chatter3.chatter3.model.dto;

public record MessageUserChatterViewDto(
        Long id,
        String message,
        Long userChatterId,
        String userChatterLogin,
        String userChatterFullName) {

    public MessageUserChatterViewDto {}
}
