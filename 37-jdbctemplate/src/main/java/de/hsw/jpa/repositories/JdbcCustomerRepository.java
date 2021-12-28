package de.hsw.jpa.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import de.hsw.jpa.beans.Customer;

public class JdbcCustomerRepository implements CustomerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer save(Customer c) {

        jdbcTemplate.update("INSERT INTO T_CUSTOMER(ID, CUSTOMER_NAME, BIRTH_DATE) VALUES (?, ?, ?)", c.getId(), c.getName(), c.getBirthDate());

        return c;
    }

    public Customer get(long id) {
        ResultSetExtractor<Customer> rse = new CustomerExtractor();
        Customer c = jdbcTemplate.query("SELECT * FROM T_CUSTOMER WHERE ID = ?", rse, id);
        return c;
    }

    private class CustomerExtractor implements ResultSetExtractor<Customer> {

        @Override
        public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
            Customer customer = null;

            while (rs.next()) {
                if (customer == null) {
                    long id = rs.getLong("ID");
                    String name = rs.getString("CUSTOMER_NAME");
                    LocalDate birthdate = rs.getDate("BIRTH_DATE").toLocalDate();
                    customer = new Customer(id, name, birthdate);
                }

            }

            if (customer == null) {
                // no rows returned - throw an empty result exception
                throw new EmptyResultDataAccessException(1);
            }

            return customer;
        }
    }
}
