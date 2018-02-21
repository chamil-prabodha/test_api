package net.cake.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by chamilp on 2/20/18.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "net.cake")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories("net.cake.dao")
@EntityScan(basePackages = "net.cake.model")
public class App {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(App.class, args);
  }
}
