package ru.practicum.email;

import ru.practicum.event.model.Event;

public interface EmailService {

    void sendEmail(final Event event);

}
