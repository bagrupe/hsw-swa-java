package de.hsw.shop;

import java.time.LocalDate;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import de.hsw.shop.beans.Customer;
import de.hsw.shop.beans.Employee;
import de.hsw.shop.beans.Order;
import de.hsw.shop.beans.OrderItem;
import de.hsw.shop.beans.Product;
import de.hsw.shop.beans.Shop;
import de.hsw.shop.services.CustomerService;
import de.hsw.shop.services.EmployeeService;
import de.hsw.shop.services.OrderService;
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
		private OrderService orderService;
		private ProductService productService;
		private ShopService shopService;

		@Autowired
		public Runner(CustomerService customerService, EmployeeService employeeService, OrderService orderService,
				ProductService productService, ShopService shopService) {
			this.customerService = customerService;
			this.employeeService = employeeService;
			this.orderService = orderService;
			this.productService = productService;
			this.shopService = shopService;
		}

		@Override
		public void run(String... args) throws Exception {
			Shop shop = new Shop("Craft Beer Shop", "BIGGEST Craft Beer Shop", null);
			shop = shopService.save(shop);
			log.log(Level.INFO, "Shop gespeichert: " + shop);

			Employee employee = new Employee("Max", "Mustermann", "Craft1234", true);
			employee = employeeService.save(employee);
			log.log(Level.INFO, "Employee gespeichert: " + employee);

			Customer customer = new Customer("Max", "Mustermann", "Craft1234", LocalDate.of(2000, 1, 1), "Musterstr.",
					"4a", "12345", "Musterstadt", "Musterland", "DE15111111110000000001", true);
			customer = customerService.save(customer);
			log.log(Level.INFO, "Customer gespeichert: " + customer);

			Product product = new Product("Beer", "Regular Beer", "Regular Beer 5%", null, 1.5, 19, true);
			product = productService.save(product);
			log.log(Level.INFO, "Product gespeichert: " + product);

			Order order = new Order(customer, LocalDate.now(), 0, customer.getIban());
			OrderItem item = new OrderItem(order, product, 1, 1.5, 19);
			order.getOrderItems().add(item);
			order = orderService.save(order);
			log.log(Level.INFO, "Order gespeichert: " + order);

		}

	}
}
