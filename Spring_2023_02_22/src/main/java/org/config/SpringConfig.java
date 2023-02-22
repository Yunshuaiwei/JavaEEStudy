package org.config;

import org.beans.OtherBean;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/22 14:38
 */
@Configuration
@ComponentScan({"org.dao","org.service","org.beans","org.config"})
@PropertySource("classpath:jdbc.properties")
//导入配置类
@Import(OtherBean.class)
//mapper的接口扫描
@MapperScan("org.mapper")
public class SpringConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
}
