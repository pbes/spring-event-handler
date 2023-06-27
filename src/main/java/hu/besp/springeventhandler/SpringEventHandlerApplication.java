package hu.besp.springeventhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Function;

@SpringBootApplication
@Slf4j
public class SpringEventHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventHandlerApplication.class, args);
	}

	@Bean
	public Function<Message<String>, String> uppercase() {
		return message -> {
			log.info("Uppercase function called: {}", message.getPayload());
			return message.getPayload().toUpperCase();
		};
	}

	@Bean
	public Function<Message<User>, String> createUser() {
		return message -> {
			log.info("Create user function called: {}", message.getPayload());
			return message.getPayload().getId();
		};
	}

	@Bean
	public Function<Message<String>, String> uppercaseLogger() {
		return message -> {
			log.info(message.getPayload());
			return message.getPayload();
		};
	}

}
