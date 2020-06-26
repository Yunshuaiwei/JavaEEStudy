package ysw.dao;

import ysw.Account;

/**
 * 持久层
 * @Param
 * @return
 **/
public interface IAccountDao {

    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
