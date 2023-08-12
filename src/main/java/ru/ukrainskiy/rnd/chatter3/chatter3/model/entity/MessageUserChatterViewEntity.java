package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "message_user_chatter_view")
public class MessageUserChatterViewEntity extends EntityLongId {
    
    @EqualsAndHashCode.Include
    private String message;

    @EqualsAndHashCode.Include
    private Long userChatterId;

    @EqualsAndHashCode.Include
    private String userChatterLogin;

    @EqualsAndHashCode.Include
    private String userChatterFullName;

}
