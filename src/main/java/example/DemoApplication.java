package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		java.security.Security.setProperty("networkaddress.cache.ttl" , "5");
		SpringApplication.run(DemoApplication.class, args);
	}
}
