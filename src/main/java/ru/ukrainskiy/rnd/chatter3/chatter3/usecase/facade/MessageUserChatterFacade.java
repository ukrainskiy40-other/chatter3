package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.MessageChatterEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.MessageUserChatterViewEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserChatterEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.EntityNotFoundException;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository.MessageChatterRepository;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository.MessageUserChatterViewRepository;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.repository.UserChatterRepository;

@Service
@RequiredArgsConstructor
@Validated
public class MessageUserChatterFacade {

    private final MessageUserChatterViewRepository messageUserChatterViewRepository;
    private final MessageChatterRepository messageChatterRepository;
    private final UserChatterRepository userChatterRepository;

    public List<MessageUserChatterViewEntity> findAllMessage() {
        return messageUserChatterViewRepository.findAll();
    }

    public List<MessageUserChatterViewEntity> findAllByUserChatterId(@NotNull @Valid Long userId) {
        return messageUserChatterViewRepository.findAllByUserChatterId(userId);
    }

    public MessageUserChatterViewEntity findById(Long messageId) {
        return messageUserChatterViewRepository.findById(messageId).orElseThrow(() -> new EntityNotFoundException("message by id not found"));
    }
    
    public MessageChatterEntity createMessage(@NotBlank @Valid String message, @NotNull @Valid Long userChatterId, Long returnMessageId) {
        UserChatterEntity userEntity = userChatterRepository.findById(userChatterId).orElseThrow(() -> new EntityNotFoundException("User by id not found."));
        MessageChatterEntity entity = new MessageChatterEntity();
        entity.setMessage(message);
        entity.setUserChatter(userEntity);
        if (returnMessageId != null) {
            Optional<MessageChatterEntity> returnMessage = messageChatterRepository.findById(returnMessageId);
            if (returnMessage.isPresent()) {
                entity.setReturnMessageChatter(returnMessage.get());
            }
        }
        return messageChatterRepository.save(entity);
    }
    
}
