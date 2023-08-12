package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "user_role")
public class UserRoleEntity extends EntityLongId {
    
    @Column(name = "role_name")
    @EqualsAndHashCode.Include
    private String userRole;

    @OneToMany(mappedBy = "userRole")
    private List<UserChatterEntity> userChatter = new ArrayList<>();
}
