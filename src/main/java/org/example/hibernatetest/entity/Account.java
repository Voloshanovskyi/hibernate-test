package org.example.hibernatetest.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
    public void setId(final Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(final Integer age) {
        this.age = age;
    }
    private Integer age;

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
