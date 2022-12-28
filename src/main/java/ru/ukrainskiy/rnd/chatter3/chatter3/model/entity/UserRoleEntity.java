package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role")
public class UserRoleEntity extends EntityLongId {
    
    @Column(name = "role_name")
    private String userRole;

    @OneToMany(mappedBy = "userRole")
    private List<UserChatterEntity> userChatter = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserRoleEntity)) {
            return false;
        }
        UserRoleEntity userRoleEntity = (UserRoleEntity) o;
        return Objects.equals(userRole, userRoleEntity.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userRole);
    }


    @Override
    public String toString() {
        return "{" +
            " userRole='" + getUserRole() + "'" +
            "}";
    }


}
