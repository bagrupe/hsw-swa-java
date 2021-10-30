package de.hsw.swa1jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.hsw.swa1jpa.beans.Address;
import de.hsw.swa1jpa.beans.Customer;
import de.hsw.swa1jpa.repositories.AddressRepository;
import de.hsw.swa1jpa.repositories.CustomerRepository;

/**
 * Variante 4: @OneToMany
 */
@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Component
	public class JpaRunner implements CommandLineRunner {
		private AddressRepository addressRepo;
		private CustomerRepository customerRepo;

		@Autowired
		public JpaRunner(AddressRepository addressRepo, CustomerRepository customerRepo) {
			this.addressRepo = addressRepo;
			this.customerRepo = customerRepo;
		}

		/**
		 * Sobald wir eine Liste nutzen, brauchen wir @Transactionel um Lazy Loading zu ermöglichen
		 * Dafür müssen wir in diesem minimalen Beispiel das "final" bei der class JpaRunner herausnehmen
		 */
		@Override
		@Transactional
		public void run(String... args) throws Exception {
			Address a = new Address("Street 12", "999 Town", 0);
			Customer c = new Customer(0, "XXX", LocalDate.now(), 0);
			a.setCustomer(c);
			c.getAddresses().add(a);

			customerRepo.save(c);

			addressRepo.findAll().forEach(x -> System.out.println(x));
			customerRepo.findAll().forEach(x -> System.out.println(x));
		}

	}

}
