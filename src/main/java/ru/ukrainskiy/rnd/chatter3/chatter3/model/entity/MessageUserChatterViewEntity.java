package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "message_user_chatter_view")
public class MessageUserChatterViewEntity extends EntityLongId {
    
    private String message;
    private Long userChatterId;
    private String userChatterLogin;
    private String userChatterFullName;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserChatterId() {
        return userChatterId;
    }

    public void setUserChatterId(Long userChatterId) {
        this.userChatterId = userChatterId;
    }

    public String getUserChatterLogin() {
        return userChatterLogin;
    }

    public void setUserChatterLogin(String userChatterLogin) {
        this.userChatterLogin = userChatterLogin;
    }

    public String getUserChatterFullName() {
        return userChatterFullName;
    }

    public void setUserChatterFullName(String userChatterFullName) {
        this.userChatterFullName = userChatterFullName;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MessageUserChatterViewEntity)) {
            return false;
        }
        MessageUserChatterViewEntity messageUserChatterViewEntity = (MessageUserChatterViewEntity) o;
        return Objects.equals(message, messageUserChatterViewEntity.message) && Objects.equals(userChatterId, messageUserChatterViewEntity.userChatterId) && Objects.equals(userChatterLogin, messageUserChatterViewEntity.userChatterLogin) && Objects.equals(userChatterFullName, messageUserChatterViewEntity.userChatterFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, userChatterId, userChatterLogin, userChatterFullName);
    }


    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", userChatterId='" + getUserChatterId() + "'" +
            ", userChatterLogin='" + getUserChatterLogin() + "'" +
            ", userChatterFullName='" + getUserChatterFullName() + "'" +
            "}";
    }

}
