package ysw.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ysw.domain.Account;

import java.util.List;

/**
 * @author 17790
 */
@Repository
public interface AccountDao {
    /**
     * @Param []
     * @return java.util.List<ysw.domain.Account>
     * @Date 20:41 2020/7/4
     * @Description: //TODO
     **/
    @Select("select *from account")
    public List<Account> findAll();

    /**
     * @Param [account]
     * @return void
     * @Date 20:41 2020/7/4
     * @Description: 保存账户信息
     **/
    @Insert("insert into account(name,money)values(#{name},#{money})")
    public void saveAccount(Account account);

}
