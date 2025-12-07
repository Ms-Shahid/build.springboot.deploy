package app.coding.codingstuttle.impl;

import app.coding.codingstuttle.Notification;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@ConditionalOnProperty(name = "notification.type", havingValue = "email")
public class EmailNotificationService implements Notification {


    @Override
    public void send(String message) {

        System.out.println("Email notification ..." + message);
    }
}
