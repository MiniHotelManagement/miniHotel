package edu.sjsu.cmpe275Project.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by:
 * Emeka Itegbe, Rajat Bansal, Yingzhu Deng, Xaio Wei
 * on 11/17/15.
 *
 */
@Configuration
public class DBConfig {

    @Value("${db.driver}")
    private String db_driver;
    @Value("${db.password}")
    private String db_password;
    @Value("${db.url}")
    private String db_url;
    @Value("${db.username}")
    private String db_username;

    //hibernate
    @Value("${hibernate.dialect}")
    private String hb_dialect;
    @Value("${hibernate.show_sql}")
    private String hb_show_sql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hb_hbm2ddl;

    @Bean(name="datasource")
    public DataSource dataSource() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(db_driver);
        driverManagerDataSource.setUrl(db_url);
        driverManagerDataSource.setUsername(db_username);
        driverManagerDataSource.setPassword(db_password);
        return driverManagerDataSource;
    }

    @Bean(name="sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hb_dialect);
        properties.put("hibernate.hbm2ddl.auto", hb_hbm2ddl);
        properties.put("hibernate.show_sql", hb_show_sql);
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    @Bean(name="transactionManager")
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
