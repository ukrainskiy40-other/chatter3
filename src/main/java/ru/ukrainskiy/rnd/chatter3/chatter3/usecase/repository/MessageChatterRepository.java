package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.MessageChatterEntity;

public interface MessageChatterRepository extends JpaRepository<MessageChatterEntity, Long> {
    
}
