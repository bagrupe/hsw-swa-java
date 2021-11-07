package de.hsw.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.hsw.jpa.beans.Address;
import de.hsw.jpa.beans.Customer;
import de.hsw.jpa.beans.CustomerAddress;
import de.hsw.jpa.beans.CustomerAddressId;
import de.hsw.jpa.repositories.AddressRepository;
import de.hsw.jpa.repositories.CustomerAddressRepository;
import de.hsw.jpa.repositories.CustomerRepository;

/**
 * Variante 6: Zwischenbean mit 2x OneToMany
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
		private CustomerAddressRepository caRepo;

		@Autowired
		public JpaRunner(AddressRepository addressRepo, CustomerRepository customerRepo, CustomerAddressRepository caRepo) {
			this.addressRepo = addressRepo;
			this.customerRepo = customerRepo;
			this.caRepo = caRepo;
		}

		@Override
		@Transactional
		public void run(String... args) throws Exception {
			Address a = new Address("Street 12", "999 Town", 0);
			Customer c = new Customer(0, "XXX", LocalDate.now(), 0);

			CustomerAddress ca = new CustomerAddress();
			ca.setId(new CustomerAddressId(c.getId(), a.getId()));
			ca.setAddress(a);
			ca.setCustomer(c);

			a.getCustomers().add(ca);
			c.getAddresses().add(ca);

			customerRepo.save(c);
			addressRepo.save(a);
			caRepo.save(ca);
			
			addressRepo.findAll().forEach(x -> System.out.println(x));
			customerRepo.findAll().forEach(x -> System.out.println(x));
		}

	}

}
