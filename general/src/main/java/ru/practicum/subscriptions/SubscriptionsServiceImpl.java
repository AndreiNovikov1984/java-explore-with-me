package ru.practicum.subscriptions;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.practicum.subscriptions.model.Subscription;
import ru.practicum.users.UserService;

import java.util.Collection;


@Service
@RequiredArgsConstructor
public class SubscriptionsServiceImpl implements SubscriptionsService {
    private final SubscriptionsRepository subscribersRepository;
    private final UserService userService;

    public Page<Subscription> getMySubscriptions(Long userId, Integer from, Integer size) {
        Pageable page = PageRequest.of((from / size), size);
        return subscribersRepository.findBySubscriberId(userId, page);
    }

    public Page<Subscription> getMySubscribers(Long userId, Integer from, Integer size) {
        Pageable page = PageRequest.of((from / size), size);
        return subscribersRepository.findByUserId(userId, page);
    }

    public Collection<Subscription> getAllSubscribers(Long userId) {
        return subscribersRepository.findByUserId(userId);
    }

    public Subscription postSubscribe(Long subscriber, Long subscribeToId) {
        if (subscribersRepository.findByUserIdAndSubscriberId(subscribeToId, subscriber) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This subscribe is repeated");
        }
        Subscription newSubscription = Subscription.builder()
                .user(userService.getUser(subscribeToId))
                .subscriber(userService.getUser(subscriber))
                .build();
        return subscribersRepository.save(newSubscription);
    }

    public void deleteSubscribe(Long subscriber, Long subscribeToId) {
        Subscription subscription = subscribersRepository.findByUserIdAndSubscriberId(subscribeToId, subscriber);
        subscribersRepository.deleteById(subscription.getId());
    }
}
