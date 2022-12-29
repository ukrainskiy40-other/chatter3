package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserChatterEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.EntityNotFoundException;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository.UserChatterRepository;

@Service
@RequiredArgsConstructor
public class UserChatterFacade {

    private final UserChatterRepository repository;

    public List<UserChatterEntity> findAll() {
        return repository.findAll();
    }

    public Optional<UserChatterEntity> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<UserChatterEntity> findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public UserChatterEntity save(UserChatterEntity entity) {
        return repository.save(entity);
    }

    public void setActive(Long id) {
        UserChatterEntity entity = findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserChatter by id not found."));
        entity.setActive(true);
        repository.save(entity);
    }
}
