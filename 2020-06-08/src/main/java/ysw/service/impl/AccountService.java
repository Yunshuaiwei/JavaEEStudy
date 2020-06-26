package ysw.service.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ysw.service.IAccountService;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/17 17:15
 * @Version
 **/
@Component("accountService")
public class AccountService implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("AccountService");
    }
}


