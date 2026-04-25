package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;

public class FundingService {

    public void fundLoan(Lender lender, Loan loan, BigDecimal amount) {

        if (lender.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        lender.deductBalance(amount);
        loan.addFunding(amount);
    }
}