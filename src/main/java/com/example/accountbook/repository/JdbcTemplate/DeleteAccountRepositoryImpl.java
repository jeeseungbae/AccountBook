package com.example.accountbook.repository.JdbcTemplate;

import com.example.accountbook.domain.Account;
import com.example.accountbook.repository.DeleteAccountRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.accountbook.repository.JdbcTemplate.AccountRepositoryImpl.accountRowMapper;

@Repository
public class DeleteAccountRepositoryImpl implements DeleteAccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public DeleteAccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Account account) {
        String sql = "insert into delete_account values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                new Object[]{account.getId(),account.getCustomerId(),account.getPayMoney(),account.getMemo(),account.getCreatedAt(),account.getModifiedAt()});
    }

    @Override
    public Optional<Account> findById(Long id) {
        String sql = "select * from delete_account where id=?";
        Account resource = jdbcTemplate.queryForObject(sql,accountRowMapper,new Object[]{id});
        if(resource!=null){
            return Optional.of(resource);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from delete_account where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
