package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_email")
@Data
@EqualsAndHashCode(callSuper=false, onlyExplicitlyIncluded = true)
@SQLDelete(sql = "UPDATE user_email SET deleted = true WHERE id=?;")
@Where(clause = "deleted=false")
public class UserEmailEntity extends EntityLongId {

    @ManyToOne
    @JoinColumn(name = "user_chatter_id")
    @EqualsAndHashCode.Include
    private UserChatterEntity userChatter;

    @EqualsAndHashCode.Include
    private String userEmail;

}
