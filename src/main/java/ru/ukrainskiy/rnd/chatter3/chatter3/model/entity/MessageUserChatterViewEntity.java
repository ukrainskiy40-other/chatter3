package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "message_user_chatter_view")
public class MessageUserChatterViewEntity extends EntityLongId {
    
    private String message;
    private Long userChatterId;
    private String userChatterLogin;
    private String userChatterFullName;

}
