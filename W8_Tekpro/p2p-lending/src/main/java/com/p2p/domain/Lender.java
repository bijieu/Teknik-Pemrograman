package com.p2p.domain;

import java.math.BigDecimal;

public class Lender {

    private BigDecimal balance;

    public Lender(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deductBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}