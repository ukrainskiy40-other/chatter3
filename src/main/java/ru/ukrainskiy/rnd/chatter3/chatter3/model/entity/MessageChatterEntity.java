package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "message_chatter")
@SQLDelete(sql = "UPDATE message_chatter SET deleted = true WHERE id=?;")
@Where(clause = "deleted=false")
public class MessageChatterEntity extends EntityLongId {
    
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_chatter_id")
    private UserChatterEntity userChatter;
    @OneToOne
    @JoinColumn(name = "return_message_chatter_id")
    private MessageChatterEntity returnMessageChatter;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserChatterEntity getUserChatter() {
        return userChatter;
    }

    public void setUserChatter(UserChatterEntity userChatter) {
        this.userChatter = userChatter;
    }

    public MessageChatterEntity getReturnMessageChatter() {
        return returnMessageChatter;
    }

    public void setReturnMessageChatter(MessageChatterEntity returnMessageChatter) {
        this.returnMessageChatter = returnMessageChatter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MessageChatterEntity)) {
            return false;
        }
        MessageChatterEntity messageChatterEntity = (MessageChatterEntity) o;
        return Objects.equals(message, messageChatterEntity.message) && Objects.equals(userChatter, messageChatterEntity.userChatter) && Objects.equals(returnMessageChatter, messageChatterEntity.returnMessageChatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, userChatter, returnMessageChatter);
    }


    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", userChatter='" + getUserChatter() + "'" +
            ", returnMessageChatter='" + getReturnMessageChatter() + "'" +
            "}";
    }

}
