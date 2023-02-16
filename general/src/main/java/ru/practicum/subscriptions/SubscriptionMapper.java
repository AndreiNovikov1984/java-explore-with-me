package ru.practicum.subscriptions;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import ru.practicum.subscriptions.dto.SubscribersDto;
import ru.practicum.subscriptions.dto.SubscriptionDto;
import ru.practicum.subscriptions.model.Subscription;
import ru.practicum.users.UserMapper;

import java.util.Collection;

@Mapper(componentModel = "spring", uses = {UserMapper.class})

public interface SubscriptionMapper {

    SubscribersDto convertSubscribersToSubscribersDto(Subscription subscribers);

    Collection<SubscribersDto> convertCollectionSubscribersToSubscribersDto(Page<Subscription> subscribers);

    SubscriptionDto convertSubscribersToSubscriptionDto(Subscription subscribers);

    Collection<SubscriptionDto> convertCollectionSubscribersToSubscriptionDto(Page<Subscription> subscribers);

}
