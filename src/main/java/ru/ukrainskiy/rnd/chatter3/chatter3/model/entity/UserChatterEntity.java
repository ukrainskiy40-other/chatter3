package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
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

    @OneToMany(mappedBy = "userChatter", fetch = FetchType.LAZY)
    private List<UserEmailEntity> userEmailList = new ArrayList<>();

    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPasswordBcrypt() {
        return passwordBcrypt;
    }

    public void setPasswordBcrypt(String passwordBcrypt) {
        this.passwordBcrypt = passwordBcrypt;
    }

    public UserRoleEntity getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEntity userRole) {
        this.userRole = userRole;
    }

    public List<UserEmailEntity> getUserEmailList() {
        return this.userEmailList;
    }

    public void setUserEmailList(String email) {
        UserEmailEntity userEmailEntity = new UserEmailEntity();
        userEmailEntity.setUserChatter(this);
        userEmailEntity.setUserEmail(email);
        userEmailList.add(userEmailEntity);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserChatterEntity)) {
            return false;
        }
        UserChatterEntity userChatterEntity = (UserChatterEntity) o;
        return Objects.equals(login, userChatterEntity.login) && Objects.equals(fullName, userChatterEntity.fullName) && Objects.equals(active, userChatterEntity.active) && Objects.equals(passwordBcrypt, userChatterEntity.passwordBcrypt) && Objects.equals(userRole, userChatterEntity.userRole) && Objects.equals(userEmailList, userChatterEntity.userEmailList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, fullName, active, passwordBcrypt, userRole, userEmailList);
    }


    @Override
    public String toString() {
        return "{" +
            " login='" + getLogin() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", active='" + isActive() + "'" +
            ", passwordBcrypt='" + getPasswordBcrypt() + "'" +
            ", userRole='" + getUserRole() + "'" +
            "}";
    }


}
