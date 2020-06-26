package ysw.dao;

import ysw.domain.Account;
import ysw.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    /**
     * 查询所有账户，同时包含用户名和地址信息
     * @Param []
     * @return java.util.List<ysw.domain.AccountUser>
     **/
    List<AccountUser> findAllAccount();

}
