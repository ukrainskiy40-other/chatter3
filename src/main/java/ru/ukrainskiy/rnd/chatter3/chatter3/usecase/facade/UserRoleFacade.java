package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserRoleEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.EntityNotFoundException;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.UserRoleDeletedUserExistsException;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository.UserRoleRepository;

@Service
@RequiredArgsConstructor
public class UserRoleFacade {

    private final UserRoleRepository repository;

    public List<UserRoleEntity> findAll() {
        return repository.findAll();
    }

    public Optional<UserRoleEntity> findById(Long id) {
        return repository.findById(id);
    }

    public UserRoleEntity create(String userRole) {
        UserRoleEntity entity = new UserRoleEntity();
        entity.setUserRole(userRole);
        return repository.save(entity);
    }
    
    public void deleteById(Long id) {
        Optional<UserRoleEntity> entityOpt = findById(id);
        if (entityOpt.isEmpty()) {
            throw new EntityNotFoundException("UserRole by id " + id + " not found.");
        }
        if (!entityOpt.get().getUserRole().isEmpty()) {
            throw new UserRoleDeletedUserExistsException(
                    "UserRole " + entityOpt.get().getUserRole() + " exists UserChatter.");
        }
        repository.delete(entityOpt.get());
    
    }
}
