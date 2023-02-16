package ru.practicum.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.practicum.event.model.Event;
import ru.practicum.subscriptions.SubscriptionsService;
import ru.practicum.subscriptions.model.Subscription;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;
    private final SubscriptionsService subscriptionsService;

    @Override
    public void sendEmail(final Event event) {
        Collection<Subscription> subscribers = subscriptionsService.getAllSubscribers(event.getInitiator().getId());
        if (subscribers.size() == 0) {
            return;
        }
        for (Subscription subscription : subscribers) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("explorewithme1202@gmail.com");
            String toAddress = subscription.getSubscriber().getEmail();
            simpleMailMessage.setTo(toAddress);
            String subject = String.format("New Event - %s, will be on %s.", event.getAnnotation(), event.getEventDate().toString());
            simpleMailMessage.setSubject(subject);
            String message = String.format("Dear subscriber! We are glad to invite you on new Event - %s. Details - %s.", event.getTitle(), event.getDescription());
            simpleMailMessage.setText(message);
            log.info("Send email to address={} Subject={}, message={}", toAddress, subject, message);
            emailSender.send(simpleMailMessage);
        }
    }
}
