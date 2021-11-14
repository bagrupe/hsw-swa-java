package de.hsw.kunden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import de.hsw.kunden.services.CustomerService;

@SpringBootApplication
public class KundenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KundenApplication.class, args);
	}

	@Component
	public final class Runner implements CommandLineRunner {
		private CustomerService service;

		@Autowired
		public Runner(CustomerService service) {
			this.service = service;
		}

		@Override
		public void run(String... args) throws Exception {
			
		}

	}

}
