package net.cake.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by chamilp on 2/20/18.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("net.cake")
@EnableJpaRepositories("net.cake.dao")
@PropertySource("classpath:db.properties")
public class PersistenceJpaConfig {

  @Autowired
  private Environment environment;

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(hikariDataSource());
    em.setPackagesToScan("net.cake.model");

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    em.setJpaProperties(additionalProperties());

    return em;
  }

  @Bean
  public DataSource hikariDataSource() {
    final HikariDataSource ds = new HikariDataSource();
    ds.setMaximumPoolSize(20);
    ds.setDataSourceClassName(environment.getRequiredProperty("jdbc.dataSourceClassName"));
    ds.addDataSourceProperty("url", environment.getRequiredProperty("jdbc.url"));
    ds.addDataSourceProperty("user", environment.getRequiredProperty("jdbc.username"));
    ds.addDataSourceProperty("password", environment.getRequiredProperty("jdbc.password"));
    ds.addDataSourceProperty(
        "cachePrepStmts", environment.getRequiredProperty("hikari.cache_prep_statement"));
    ds.addDataSourceProperty(
        "prepStmtCacheSize", environment.getRequiredProperty("hikari.prep_stmt_cache_size"));
    ds.addDataSourceProperty(
        "prepStmtCacheSqlLimit",
        environment.getRequiredProperty("hikari.prep_stmt_cache_sql_limit"));
    ds.addDataSourceProperty(
        "useServerPrepStmts", environment.getRequiredProperty("hikari.use_server_prep_stmts"));
    return ds;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    JpaDialect jpaDialect = new HibernateJpaDialect();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    transactionManager.setJpaDialect(jpaDialect);
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty(
        "hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.orm_generation"));
    properties.setProperty(
        "hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
    properties.setProperty(
        "hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
    properties.setProperty(
        "hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    return properties;
  }
}
