package ru.ukrainskiy.rnd.chatter3.chatter3.model.dto;

public record UserChatterDto(
                Long id,
                String login,
                String fullName,
                Boolean active,
                UserRoleDto userRole) {
        public UserChatterDto {
        }
}
