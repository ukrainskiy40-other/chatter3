package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "user_email")
@SQLDelete(sql = "UPDATE user_email SET deleted = true WHERE id=?;")
@Where(clause = "deleted=false")
public class UserEmailEntity extends EntityLongId {

    @ManyToOne
    @JoinColumn(name = "user_chatter_id")
    private UserChatterEntity userChatter;
    private String userEmail;
    
}
