package de.hsw.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import de.hsw.jpa.repositories.AddressRepository;
import de.hsw.jpa.repositories.CustomerRepository;
import de.hsw.jpa.repositories.JdbcAddressRepository;
import de.hsw.jpa.repositories.JdbcCustomerRepository;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

	JdbcTemplate jdbcTemplate;

	@Autowired  // Optional, Spring will autowire DataSource anyway
	public JdbcConfig(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Bean
	public CustomerRepository customerRepository(){
		JdbcCustomerRepository repository = new JdbcCustomerRepository(jdbcTemplate);
		return repository;
	}
	
	@Bean
	public AddressRepository restaurantRepository(){
		JdbcAddressRepository repository = new JdbcAddressRepository(jdbcTemplate);
		return repository;
	}
	
}
