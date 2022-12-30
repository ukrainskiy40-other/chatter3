package ru.ukrainskiy.rnd.chatter3.chatter3.model.dto;

import lombok.Data;

@Data
public class UserChatterDto {
        
        private Long id;
        private String login;
        private String fullName;
        private Boolean active;
        private UserRoleDto userRole;
    
}
