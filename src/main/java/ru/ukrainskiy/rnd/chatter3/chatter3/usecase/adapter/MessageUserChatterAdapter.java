package ru.ukrainskiy.rnd.chatter3.chatter3.usecase.adapter;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.MessageUserChatterViewDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.MessageChatterEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserChatterEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.EntityNotFoundException;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.form.MessageChatterForm;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.mapper.MessageUserChatterViewMapper;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade.MessageUserChatterFacade;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade.UserChatterFacade;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class MessageUserChatterAdapter {

    private final MessageUserChatterFacade messageUserChatterViewFacade;
    private final MessageUserChatterViewMapper messageUserChatterViewMapper;
    private final UserChatterFacade userChatterFacade;

    public List<MessageUserChatterViewDto> findAllMessageByUserId() {

        return messageUserChatterViewMapper
                .toListDto(messageUserChatterViewFacade.findAllByUserChatterId(getUserContext().getId()));
    }

    public MessageUserChatterViewDto createMessage(@NotNull @Valid MessageChatterForm form) {

        MessageChatterEntity messageChatterEntity = messageUserChatterViewFacade.createMessage(form.message(), getUserContext().getId(),
                form.returnMessageId());

        return messageUserChatterViewMapper.toDto(messageUserChatterViewFacade.findById(messageChatterEntity.getId()));

    }

    private UserChatterEntity getUserContext() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserChatterEntity userEntity = userChatterFacade.findByLogin(auth.getName())
                .orElseThrow(() -> new EntityNotFoundException(null));
        return userEntity;
    }


}
