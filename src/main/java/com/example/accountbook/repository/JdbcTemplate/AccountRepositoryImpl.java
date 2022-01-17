package com.example.accountbook.repository.JdbcTemplate;

import com.example.accountbook.domain.Account;
import com.example.accountbook.domain.dto.AccountDetailDto;
import com.example.accountbook.domain.dto.AccountDto;
import com.example.accountbook.repository.AccountRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public List<AccountDto> findAll(Long customerId) {
        String sql = "select * from account where customer_id = ? order by created_at desc";
        List<AccountDto> resources = jdbcTemplate.query(sql,accountDtoRowMapper,customerId);
        return resources;
    }

    @Override
    public Optional<AccountDetailDto> findDetailById(Long id) {
        String sql = "select account.id,customer.email,customer.roles,account.pay_money,account.memo,account.created_at,account.modified_at " +
                "from customer inner join account on customer.id = account.customer_id where account.id=?";
        AccountDetailDto resource = jdbcTemplate.queryForObject(sql,accountDetailDtoRowMapper,new Object[]{id});
        if(resource!=null){
            return Optional.of(resource);
        }
        return Optional.empty();
    }

    static RowMapper<AccountDetailDto> accountDetailDtoRowMapper = (rs, rowNum) ->
            AccountDetailDto.builder()
                    .id(rs.getLong("account.id"))
                    .email(rs.getString("customer.email"))
                    .roles(rs.getString("customer.roles"))
                    .payMoney(rs.getLong("account.pay_money"))
                    .memo(rs.getString("account.memo"))
                    .createdAt(dateTimeOf(rs.getTimestamp("account.created_at")))
                    .modifiedAt(dateTimeOf(rs.getTimestamp("account.modified_at")))
                    .build();

    static RowMapper<AccountDto> accountDtoRowMapper = (rs, rowNum) ->
            AccountDto.builder()
                    .id(rs.getLong("id"))
                    .payMoney(rs.getLong("pay_money"))
                    .memo(rs.getString("memo"))
                    .build();

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