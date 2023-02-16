package ru.practicum.subscriptions;

import org.springframework.data.domain.Page;
import ru.practicum.subscriptions.model.Subscription;

import java.util.Collection;


public interface SubscriptionsService {
    Page<Subscription> getMySubscriptions(Long userId, Integer from, Integer size);

    Page<Subscription> getMySubscribers(Long userId, Integer from, Integer size);

    Collection<Subscription> getAllSubscribers(Long userId);

    Subscription postSubscribe(Long userId, Long subscribeToId);

    void deleteSubscribe(Long subscribeToId, Long subscriber);
}
