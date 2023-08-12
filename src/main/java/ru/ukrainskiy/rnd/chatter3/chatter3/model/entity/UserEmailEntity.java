package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_email")
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
    
    
    public UserChatterEntity getUserChatter() {
        return userChatter;
    }

    public void setUserChatter(UserChatterEntity userChatter) {
        this.userChatter = userChatter;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEmailEntity)) {
            return false;
        }
        UserEmailEntity userEmailEntity = (UserEmailEntity) o;
        return Objects.equals(userChatter, userEmailEntity.userChatter) && Objects.equals(userEmail, userEmailEntity.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userChatter, userEmail);
    }


    @Override
    public String toString() {
        return "{" +
            " userChatter='" + getUserChatter() + "'" +
            ", userEmail='" + getUserEmail() + "'" +
            "}";
    }

}
