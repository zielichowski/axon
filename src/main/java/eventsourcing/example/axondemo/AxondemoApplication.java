package eventsourcing.example.axondemo;

import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AxondemoApplication {
	@Bean
	public EventStorageEngine eventStore() {
		return new InMemoryEventStorageEngine();
	}

	public static void main(String[] args) {
		SpringApplication.run(AxondemoApplication.class, args);
	}
}
