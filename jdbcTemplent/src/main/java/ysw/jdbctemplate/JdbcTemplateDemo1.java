package jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ysw.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/21 20:08
 * @Version
 **/
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

//        jt.update("insert into account(name,money)values (?,?)","ysw",1000);
//        jt.update("update account set name=?,money=? where id=?","test",1234,5);
//        jt.update("delete from account where id=?",5);
//        List<Account> query = jt.query("select * from account where money>?", new AccountRowMapper(), 500);
        List<Account> query = jt.query("select * from account where money>?",
                new BeanPropertyRowMapper<Account>(Account.class), 500);

        for (Account account : query) {
            System.out.println(account);
        }
        Integer count = jt.queryForObject("select count(*) from account where money>?", Integer.class, 500);
        System.out.println(count);
    }
}

/**
 * 封装结果集
 *
 * @Param
 * @return
 **/
class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account a = new Account();
        a.setId(resultSet.getInt("id"));
        a.setName(resultSet.getString("name"));
        a.setMoney(resultSet.getDouble("money"));
        return a;
    }
}
