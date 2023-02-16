package ru.practicum.subscriptions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.subscriptions.model.Subscription;

import java.util.Collection;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscription, Long> {

    Page<Subscription> findBySubscriberId(Long userId, Pageable page);

    Page<Subscription> findByUserId(Long userId, Pageable page);

    Collection<Subscription> findByUserId(Long userId);

    Subscription findByUserIdAndSubscriberId(Long userId, Long subscriber);

    void deleteByUserId(Long userId);

    void deleteBySubscriberId(Long userId);
}
