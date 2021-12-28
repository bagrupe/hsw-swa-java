package de.hsw.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import de.hsw.jpa.beans.Address;
import de.hsw.jpa.beans.Customer;
import de.hsw.jpa.repositories.AddressRepository;
import de.hsw.jpa.repositories.CustomerRepository;

/**
 * JDBC Templates
 */
@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Component
	public final class JdbcRunner implements CommandLineRunner {
		private AddressRepository addressRepo;
		private CustomerRepository customerRepo;

		@Autowired
		public JdbcRunner(AddressRepository addressRepo, CustomerRepository customerRepo) {
			this.addressRepo = addressRepo;
			this.customerRepo = customerRepo;
		}

		@Override
		public void run(String... args) throws Exception {
			Address a = new Address(0, "Street 12", "999 Town");
			Customer c = new Customer(0, "XXX", LocalDate.now());

			addressRepo.save(a);
			customerRepo.save(c);

			System.out.println(addressRepo.get(0));
			System.out.println(customerRepo.get(0));
		}

	}

}
