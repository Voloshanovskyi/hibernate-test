package org.example.hibernatetest.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bill> bills;

    @Override
    public String toString() {
        return "Account{" + "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               '}';
    }

    public Account(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    private Integer age;

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
