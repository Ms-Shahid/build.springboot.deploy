package app.coding.codingstuttle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingstuttleApplication implements CommandLineRunner {

	@Autowired
	PaymentService paymentService1;

	@Autowired
	PaymentService paymentService2;

	public static void main(String[] args) {
		SpringApplication.run(CodingstuttleApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		paymentService1.pay();
		paymentService2.pay();

		System.out.println(paymentService1.hashCode());
		System.out.println(paymentService2.hashCode());
	}
}
