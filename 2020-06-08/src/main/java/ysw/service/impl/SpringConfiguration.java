package ysw.service.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/20 10:31
 * @Version
 **/
@Configuration
@ComponentScan("ysw.service")
public class SpringConfiguration {

    @Bean("runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/……");
            ds.setUser("root");
            ds.setPassword("……");
            return ds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
