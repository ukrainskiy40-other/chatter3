package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserEmailEntity;

public interface UserEmailRepository extends JpaRepository<UserEmailEntity, Long> {

    Optional<UserEmailEntity> findByUserEmail(String userEmail);
    
}
