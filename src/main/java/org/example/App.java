package org.example;

import org.example.hibernatetest.dao.AccountDAO;
import org.example.hibernatetest.entity.Account;
import org.example.hibernatetest.entity.Bill;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class App implements CommandLineRunner {
    final
    AccountDAO accountDAO;

    public App(final AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(final String... args) {
        Account account = new Account("Lori", 15);
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill(10));
        bills.add(new Bill(11));
        bills.add(new Bill(12));
        bills.add(new Bill(13));
        bills.add(new Bill(14));
        account.setBills(bills);
        Account saveAccount = accountDAO.save(account);
        Account accountFromDataBase = accountDAO.findById(saveAccount.getId());
        System.out.println(accountFromDataBase);
        System.out.println(accountFromDataBase.getBills());
    }
}
