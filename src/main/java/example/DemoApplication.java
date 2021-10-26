package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		java.security.Security.setProperty("networkaddress.cache.ttl" , "1");
		// https://github.com/brettwooldridge/HikariCP/issues/1075#issuecomment-364973591
		java.security.Security.setProperty("networkaddress.cache.negative.ttl" , "0");
		SpringApplication.run(DemoApplication.class, args);
	}
}
