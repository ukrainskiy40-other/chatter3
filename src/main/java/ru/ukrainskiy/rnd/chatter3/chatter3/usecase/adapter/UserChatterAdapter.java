package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.UserChatterDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserChatterEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserRoleEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.form.SignupForm;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.mapper.UserChatterMapper;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade.UserChatterFacade;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade.UserRoleFacade;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class UserChatterAdapter {

    private final UserChatterFacade facade;
    private final UserRoleFacade userRoleFacade;
    private final UserChatterMapper mapper;

    public List<UserChatterDto> findAllUserChatter() {
        return mapper.toListDto(facade.findAll());
    }

    public void registerUserChatter(@NotNull @Valid SignupForm form) {

        if (facade.findByLogin(form.username()).isPresent()) {
            throw new RuntimeException();
        }
        if (facade.findByEmail(form.email()).isPresent()) {
        throw new RuntimeException();
        }
        var passwordEncoder = new BCryptPasswordEncoder();
        UserChatterEntity entity = new UserChatterEntity();
        entity.setActive(false);
        entity.setLogin(form.username().toLowerCase());
        entity.setPasswordBcrypt(passwordEncoder.encode(form.password()));
        entity.setFullName(form.fullName());
        entity.setUserEmailList(form.email());
        Optional<UserRoleEntity> userRoleEntity = userRoleFacade.findById(1l);
        if (userRoleEntity.isPresent()) {
            entity.setUserRole(userRoleEntity.get());
        }
        facade.save(entity);
    }

    public void setActive(Long id) {
        facade.setActive(id);
    }
}
