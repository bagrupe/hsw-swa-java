package de.hsw.jpa.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import de.hsw.jpa.beans.Address;

public class JdbcAddressRepository implements AddressRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAddressRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Address save(Address a) {
        // Problem: SQL-Injection möglich, aufpassen!
        // jdbcTemplate.update("INSERT INTO T_ADDRESS(ID, STREET, ZIP_CITY) VALUES
        // ("+a.getId()+", '"+a.getStreet()+"', '"+a.getZipCity()+"' )");

        // Lösung: Prepared Statements
        jdbcTemplate.update("INSERT INTO T_ADDRESS(ID, STREET, ZIP_CITY) VALUES (?, ?, ?)", a.getId(), a.getStreet(),
                a.getZipCity());

        return a;
    }

    public Address get(long id) {
        ResultSetExtractor<Address> rse = new AddressExtractor();
        Address a = jdbcTemplate.query("SELECT * FROM T_ADDRESS WHERE ID = ?", rse, id);
        return a;
    }

    private class AddressExtractor implements ResultSetExtractor<Address> {

        @Override
        public Address extractData(ResultSet rs) throws SQLException, DataAccessException {
            Address address = null;

            while (rs.next()) {
                if (address == null) {
                    long id = rs.getLong("ID");
                    String street = rs.getString("STREET");
                    String zipcity = rs.getString("ZIP_CITY");
                    address = new Address(id, street, zipcity);
                }

            }

            if (address == null) {
                // no rows returned - throw an empty result exception
                throw new EmptyResultDataAccessException(1);
            }

            return address;
        }
    }
}
