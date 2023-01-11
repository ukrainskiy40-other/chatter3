package ru.ukrainskiy.rnd.chatter3.chatter3.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import ru.ukrainskiy.rnd.chatter3.chatter3.model.dto.MessageUserChatterViewDto;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.MessageUserChatterViewEntity;

@Mapper(componentModel = "spring")
public interface MessageUserChatterViewMapper {
    
    MessageUserChatterViewDto toDto(MessageUserChatterViewEntity entity);
    List<MessageUserChatterViewDto> toListDto(List<MessageUserChatterViewEntity> entity);
    
}
