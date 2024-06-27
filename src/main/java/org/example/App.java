package org.example;

import org.example.hibernatetest.dao.AccountDAO;
import org.example.hibernatetest.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class App implements CommandLineRunner {
        @Autowired
    AccountDAO accountDAO;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Override
    public void run(final String... args) {
        Account account = new Account("Lori", 15);
        Account saveAccount = accountDAO.save(account);
        System.out.println(accountDAO.findById(saveAccount.getId()));
    }
}
