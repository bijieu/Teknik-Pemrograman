package com.p2p;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(0);

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow() {

        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }

    @Test
    void shouldNotActivateLoanIfNotFunded() {

        Loan loan = new Loan(); // masih PENDING
        LoanService service = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.activateLoan(loan);
        });
    }

    @Test
    void shouldActivateLoanWhenFunded() {

        Loan loan = new Loan();
        loan.addFunding(BigDecimal.valueOf(1000)); // jadi FUNDED

        LoanService service = new LoanService();

        service.activateLoan(loan);

        assertEquals(Loan.Status.ACTIVE, loan.getStatus());
    }

    @Test
    void shouldAllowRepaymentWhenLoanActive() {

        Loan loan = new Loan();
        loan.addFunding(BigDecimal.valueOf(1000));
        loan.activate();

        LoanService service = new LoanService();

        service.repayLoan(loan, BigDecimal.valueOf(200));

        assertTrue(true); // minimal dulu
    }

    @Test
    void shouldRejectRepaymentWhenAmountInvalid() {

        Loan loan = new Loan();
        loan.addFunding(BigDecimal.valueOf(1000));
        loan.activate();

        LoanService service = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.repayLoan(loan, BigDecimal.ZERO);
        });
    }

    @Test
    void shouldReduceOutstandingWhenRepay() {

        Loan loan = new Loan();
        loan.addFunding(BigDecimal.valueOf(1000));
        loan.activate();

        LoanService service = new LoanService();

        service.repayLoan(loan, BigDecimal.valueOf(200));

        assertEquals(BigDecimal.valueOf(800), loan.getOutstanding());
    }

    @Test
    void shouldCompleteLoanWhenOutstandingZero() {

        Loan loan = new Loan();
        loan.addFunding(BigDecimal.valueOf(1000));
        loan.activate();

        LoanService service = new LoanService();

        service.repayLoan(loan, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.COMPLETED, loan.getStatus());
    }

}