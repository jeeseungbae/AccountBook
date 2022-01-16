package com.example.accountbook.repository.JdbcTemplate;

import com.example.accountbook.domain.Customer;
import com.example.accountbook.repository.CustomerRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Customer customer) {
        String sql = "insert into customer(email,password,roles) values(?,?,?)";
        jdbcTemplate.update(sql,customer.getEmail(),customer.getPassword(),customer.getRoles());
    }

    @Override
    public boolean existsEmail(String email) {
        String sql = "select count(*) from `customer` where email = ?";
        int count = jdbcTemplate.queryForObject(sql, new String[]{email},Integer.class);
        return count>0;
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        String sql = "select * from customer where email = ?";
        Customer resource = jdbcTemplate.queryForObject(sql,customerRowMapper, email);
        if(resource!=null){
            return Optional.of(resource);
        }
        return Optional.empty();
    }

    static RowMapper<Customer> customerRowMapper = (rs,rowNum) ->
            Customer.builder()
                    .id(rs.getLong("id"))
                    .email(rs.getString("email"))
                    .password(rs.getString("password"))
                    .roles(rs.getString("roles"))
                    .build();
}
