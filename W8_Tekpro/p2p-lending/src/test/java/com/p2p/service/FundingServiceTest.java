package com.p2p.service;

import com.p2p.domain.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class FundingServiceTest {

    @Test
    void shouldAllowFundingWhenBalanceSufficient() {

        Lender lender = new Lender(BigDecimal.valueOf(2000));
        Loan loan = new Loan();
        FundingService service = new FundingService();

        service.fundLoan(lender, loan, BigDecimal.valueOf(1000));

        assertEquals(BigDecimal.valueOf(1000), lender.getBalance());
    }

    @Test
    void shouldRejectFundingWhenBalanceNotEnough() {

        Lender lender = new Lender(BigDecimal.valueOf(500));
        Loan loan = new Loan();
        FundingService service = new FundingService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.fundLoan(lender, loan, BigDecimal.valueOf(1000));
        });
    }

    @Test
    void shouldMarkLoanAsFundedWhenFullyFunded() {

        Lender lender = new Lender(BigDecimal.valueOf(2000));
        Loan loan = new Loan();
        FundingService service = new FundingService();

        service.fundLoan(lender, loan, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.FUNDED, loan.getStatus());
    }
}