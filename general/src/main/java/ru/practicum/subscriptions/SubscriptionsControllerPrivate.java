package ru.practicum.subscriptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.email.EmailService;
import ru.practicum.subscriptions.dto.SubscribersDto;
import ru.practicum.subscriptions.dto.SubscriptionDto;

import javax.validation.constraints.*;
import java.util.Collection;

@RestController
@RequestMapping(path = "/users/{userId}/subscribes")
@RequiredArgsConstructor
@Slf4j
@Validated
public class SubscriptionsControllerPrivate {
    private final SubscriptionsService subscriptionsService;
    private final SubscriptionMapper subscriptionMapper;

    @GetMapping("/my")
    public ResponseEntity<Collection<SubscriptionDto>> getMySubscriptions(@Positive @PathVariable Long userId,
                                                                          @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                                                          @Positive @RequestParam(defaultValue = "10") Integer size) {
        log.info("Get subscribers of User with id={}, from={}, size={}", userId, from, size);
        return new ResponseEntity<>(subscriptionMapper.convertCollectionSubscribersToSubscriptionDto(subscriptionsService.getMySubscriptions(userId, from, size)), HttpStatus.OK);
    }

    @GetMapping("/on-me")
    public ResponseEntity<Collection<SubscribersDto>> getMySubscribers(@Positive @PathVariable Long userId,
                                                                       @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                                                       @Positive @RequestParam(defaultValue = "10") Integer size) {
        log.info("Get subscribers of User with id={}, from={}, size={}", userId, from, size);
        return new ResponseEntity<>(subscriptionMapper.convertCollectionSubscribersToSubscribersDto(subscriptionsService.getMySubscribers(userId, from, size)), HttpStatus.OK);
    }

    @PostMapping("/{subscribeToId}")
    public ResponseEntity<SubscriptionDto> postSubscribe(@Positive @PathVariable Long userId,
                                                         @Positive @PathVariable Long subscribeToId) {
        log.info("Post subscribe from User with id={} to User with id={}", userId, subscribeToId);
        return new ResponseEntity<>(subscriptionMapper.convertSubscribersToSubscriptionDto(subscriptionsService.postSubscribe(userId, subscribeToId)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{subscribeToId}")
    public ResponseEntity<HttpStatus> deleteSubscribe(@Positive @PathVariable Long userId,
                                                      @Positive @PathVariable Long subscribeToId) {
        log.info("Delete subscribe from User with id={} to User with id={}", userId, subscribeToId);
        subscriptionsService.deleteSubscribe(userId, subscribeToId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
