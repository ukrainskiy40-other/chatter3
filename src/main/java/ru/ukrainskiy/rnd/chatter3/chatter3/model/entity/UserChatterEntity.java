package ru.ukrainskiy.rnd.chatter3.chatter3.model.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@Data
@EqualsAndHashCode(callSuper=false, onlyExplicitlyIncluded = true)
@Table(name = "user_chatter")
@SQLDelete(sql = "UPDATE user_chatter SET deleted = true WHERE id=?;")
@Where(clause = "deleted=false")
public class UserChatterEntity extends EntityLongId {

    @NotBlank
    @EqualsAndHashCode.Include
    private String login;

    @NotBlank
    @EqualsAndHashCode.Include
    private String fullName;

    @EqualsAndHashCode.Include
    private Boolean active;

    @NotBlank
    @EqualsAndHashCode.Include
    private String passwordBcrypt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role_id")
    @EqualsAndHashCode.Include
    private UserRoleEntity userRole;

    @OneToMany(mappedBy = "userChatter", fetch = FetchType.LAZY)
    private List<UserEmailEntity> userEmailList = new ArrayList<>();

    @OneToMany(mappedBy = "userChatter", fetch = FetchType.LAZY)
    private List<MessageChatterEntity> messageChatterList = new ArrayList<>(); 

}
