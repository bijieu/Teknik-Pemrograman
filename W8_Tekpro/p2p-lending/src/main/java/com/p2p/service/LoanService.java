package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;

public class LoanService {

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        validateBorrower(borrower); 

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        Loan loan = new Loan();

        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else {
            loan.reject();
        }

        return loan;
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    public void activateLoan(Loan loan) {

        if (loan.getStatus() != Loan.Status.FUNDED) {
            throw new IllegalArgumentException("Loan not funded");
        }

        loan.activate();
    }

    public void repayLoan(Loan loan, BigDecimal amount) {

        if (loan.getStatus() != Loan.Status.ACTIVE) {
            throw new IllegalArgumentException("Loan not active");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid repayment amount");
        }

        loan.repay(amount);
    }
}