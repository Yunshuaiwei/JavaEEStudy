package ysw.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ysw.Account;
import ysw.dao.IAccountDao;

import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/21 20:58
 * @Version
 **/
public class AccountDaoImpl implements IAccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> query = jdbcTemplate.query("select * from account where id=?",
                new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return query.isEmpty() ? null : query.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> test = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<>(Account.class), "test");
        if (test.isEmpty()) {
            return null;
        }
        if (test.size() > 1) {
            throw new RuntimeException("结果集不唯一！！！");
        }
        return test.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=? ,money=? where id=?",
                account.getName(), account.getMoney(), account.getId()
        );
    }
}
