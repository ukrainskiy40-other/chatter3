package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
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

}
