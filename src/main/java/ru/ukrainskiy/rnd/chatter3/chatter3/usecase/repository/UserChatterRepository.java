package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserChatterEntity;

public interface UserChatterRepository extends JpaRepository<UserChatterEntity, Long> {
 
    Optional<UserChatterEntity> findByLogin(String lowerCase);
}
