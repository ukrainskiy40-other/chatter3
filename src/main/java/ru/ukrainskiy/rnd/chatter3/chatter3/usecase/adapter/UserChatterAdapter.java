package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserChatterAdapter {

    private final UserChatterFacade facade;
    private final UserRoleFacade userRoleFacade;
    private final UserChatterMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserChatterDto> findAllUserChatter() {
        return mapper.toListDto(facade.findAll());
    }

    public void registerUserChatter(SignupForm form) {

        if (facade.findByLogin(form.getUsername()).isPresent()) {
            throw new RuntimeException();
        }
        // if (facade.findByEmail(form.getEmail()).isPresent()) {
        // throw new RuntimeException();
        // }
        UserChatterEntity entity = new UserChatterEntity();
        entity.setActive(false);
        entity.setLogin(form.getUsername());
        entity.setPasswordBcrypt(passwordEncoder.encode(form.getPassword()));
        entity.setFullName(form.getUsername().toUpperCase());
        Optional<UserRoleEntity> userRoleEntity = userRoleFacade.findById(1l);
        if (userRoleEntity.isPresent()) {
            entity.setUserRole(userRoleEntity.get());
        }
        facade.save(entity);
    }
}
