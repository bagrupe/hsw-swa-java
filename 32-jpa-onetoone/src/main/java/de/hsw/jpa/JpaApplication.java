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
 * Variante 2: @OneToOne
 */
@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Component
	public final class JpaRunner implements CommandLineRunner {
		private AddressRepository addressRepo;
		private CustomerRepository customerRepo;

		@Autowired
		public JpaRunner(AddressRepository addressRepo, CustomerRepository customerRepo) {
			this.addressRepo = addressRepo;
			this.customerRepo = customerRepo;
		}

		@Override
		public void run(String... args) throws Exception {
			Address a = new Address(0, "Street 12", "999 Town",0);
			Customer c = new Customer(0, "XXX", LocalDate.now(), 0);
			a.setCustomer(c);
			c.setAddress(a);

			customerRepo.save(c);

			addressRepo.findAll().forEach(x -> System.out.println(x));
			customerRepo.findAll().forEach(x -> System.out.println(x));
		}

	}

}
