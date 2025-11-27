package app.coding.codingstuttle.impl;

import app.coding.codingstuttle.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("smsnotif")
//@ConditionalOnProperty(name = "notification.type", havingValue = "sms")
public class SmsNotificationService implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sms sending... " + message);
    }

}
