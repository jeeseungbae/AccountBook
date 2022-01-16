package com.example.accountbook.repository.JdbcTemplate;

import com.example.accountbook.domain.Account;
import com.example.accountbook.repository.AccountRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSourceExtensionsKt;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.accountbook.util.DateTimeUtils.dateTimeOf;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Account account) {
        String sql = "insert into account(customer_id,pay_money,memo,created_at) values(?,?,?,?)";
        jdbcTemplate.update(sql, account.getCustomerId(),account.getPayMoney(),account.getMemo(),account.getCreatedAt());
    }

    @Override
    public void modify(Account account) {
        String sql = "update account set pay_money=?, memo=?, modified_at=? where id=?";
        jdbcTemplate.update(sql,account.getPayMoney(),account.getMemo(),account.getModifiedAt(),account.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Optional<Account> findById(Long id) {
        String sql = "select * from account where id=?";
        Account resource = jdbcTemplate.queryForObject(sql,accountRowMapper,new Object[]{id});
        if(resource!=null){
            return Optional.of(resource);
        }
        return Optional.empty();
    }

    static RowMapper<Account> accountRowMapper = (rs, rowNum) ->
            Account.builder()
                    .id(rs.getLong("id"))
                    .customerId(rs.getLong("customer_id"))
                    .payMoney(rs.getLong("pay_money"))
                    .memo(rs.getString("memo"))
                    .createdAt(dateTimeOf(rs.getTimestamp("created_at")))
                    .modifiedAt(dateTimeOf(rs.getTimestamp("modified_at")))
                    .build();
}