package de.hsw.produkte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import de.hsw.produkte.services.ProductService;

@SpringBootApplication
public class ProdukteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdukteApplication.class, args);
	}

	@Component
	public final class Runner implements CommandLineRunner {
		private ProductService service;

		@Autowired
		public Runner(ProductService service) {
			this.service = service;
		}

		@Override
		public void run(String... args) throws Exception {
			
		}

	}
}
