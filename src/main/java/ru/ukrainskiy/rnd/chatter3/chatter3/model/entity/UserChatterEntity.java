package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_chatter")
@SQLDelete(sql = "UPDATE user_chatter SET deleted = true WHERE id=?;")
@Where(clause = "deleted=false")
public class UserChatterEntity extends EntityLongId {

    @NotBlank
    private String login;

    @NotBlank
    private String fullName;

    private Boolean active;

    @NotBlank
    private String passwordBcrypt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role_id")
    private UserRoleEntity userRole;



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserChatterEntity)) {
            return false;
        }
        UserChatterEntity userChatterEntity = (UserChatterEntity) o;
        return Objects.equals(login, userChatterEntity.login) && Objects.equals(fullName, userChatterEntity.fullName) && Objects.equals(active, userChatterEntity.active) && Objects.equals(passwordBcrypt, userChatterEntity.passwordBcrypt) && Objects.equals(userRole, userChatterEntity.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, fullName, active, passwordBcrypt, userRole);
    }


    @Override
    public String toString() {
        return "{" +
            " login='" + getLogin() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", active='" + getActive() + "'" +
            ", passwordBcrypt='" + getPasswordBcrypt() + "'" +
            ", userRole='" + getUserRole() + "'" +
            "}";
    }

}
