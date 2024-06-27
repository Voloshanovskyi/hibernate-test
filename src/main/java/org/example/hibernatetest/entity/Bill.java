package org.example.hibernatetest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private Integer amount;

    public Bill(Integer amount) {
        this.amount = amount;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(final Long billId) {
        this.billId = billId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId +
               ", amount=" + amount +
               '}';
    }
}
