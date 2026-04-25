package com.p2p.domain;

import java.math.BigDecimal;

public class Loan {

    public enum Status {
        PENDING, APPROVED, REJECTED, FUNDED, ACTIVE, COMPLETED
    }

    private Status status;

    private BigDecimal fundedAmount = BigDecimal.ZERO;
    private BigDecimal amount = BigDecimal.valueOf(1000); 
    private BigDecimal outstanding = BigDecimal.valueOf(1000);

    public Loan() {
        this.status = Status.PENDING;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }

    public Status getStatus() {
        return status;
    }

    public void addFunding(BigDecimal amount) {
        this.fundedAmount = this.fundedAmount.add(amount);

        if (this.fundedAmount.compareTo(this.amount) >= 0) {
            this.status = Status.FUNDED;
        }
    }

    public void activate() {
        if (this.status != Status.FUNDED) {
            throw new IllegalStateException("Loan not funded yet");
        }
        this.status = Status.ACTIVE;
    }

    public void repay(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid payment");
        }

        if (this.status != Status.ACTIVE) {
            throw new IllegalStateException("Loan not active");
        }

        this.outstanding = this.outstanding.subtract(amount);

        if (this.outstanding.compareTo(BigDecimal.ZERO) <= 0) {
            this.outstanding = BigDecimal.ZERO;
            this.status = Status.COMPLETED;
        }
    }

    public BigDecimal getOutstanding() {
        return outstanding;
    }
}