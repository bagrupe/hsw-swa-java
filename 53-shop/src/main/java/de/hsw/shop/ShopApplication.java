package de.hsw.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import de.hsw.shop.services.CustomerService;
import de.hsw.shop.services.EmployeeService;
import de.hsw.shop.services.ProductService;
import de.hsw.shop.services.ShopService;
import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Component
	public final class Runner implements CommandLineRunner {
		private CustomerService customerService;
		private EmployeeService employeeService;
		private ProductService productService;
		private ShopService shopService;

		@Autowired
		public Runner(CustomerService customerService, EmployeeService employeeService, 
				ProductService productService, ShopService shopService) {
			this.customerService = customerService;
			this.employeeService = employeeService;
			this.productService = productService;
			this.shopService = shopService;
		}

		@Override
		public void run(String... args) throws Exception {
			

		}

	}
}
