package app.coding.codingstuttle;

import app.coding.codingstuttle.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CodingstuttleApplication implements CommandLineRunner {

//	Notification notification;

	//constructor dependency injection
//	public CodingstuttleApplication(@Qualifier("sms") Notification notification) {
//		this.notification = notification;
//	}

	//Send notification to both email & sms
	Map<String, Notification> notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(CodingstuttleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for(var notification : notificationServiceMap.entrySet()){
			System.out.println(notification.getKey());
			notification.getValue().send("Hello");
		}
	}
}
