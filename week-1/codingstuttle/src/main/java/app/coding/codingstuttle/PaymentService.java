package app.coding.codingstuttle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void pay(){
        System.out.println("Payment instance created..");
    }

    @PostConstruct
    public void beanCreated(){
        System.out.println("Bean is creating... & before pay");
    }

    @PreDestroy
    public void beanIsDestroyed(){
        System.out.println("Bean is completely destroyed...");
    }
}
