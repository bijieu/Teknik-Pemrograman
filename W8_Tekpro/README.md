# P2P Lending System (Java + TDD)

## Identitas

* Nama: Rizni Febrianty Surya Putri
* NIM: 251524029
* Kelas: 1A

## Deskripsi Project

Project ini merupakan implementasi sederhana sistem **Peer-to-Peer (P2P) Lending** menggunakan bahasa **Java** dengan pendekatan **Test-Driven Development (TDD)**.

Sistem ini mensimulasikan proses utama dalam platform fintech:

* Pengajuan pinjaman (Loan Creation)
* Pendanaan oleh lender (Funding)
* Aktivasi pinjaman (Disbursement)
* Pembayaran cicilan (Repayment)

---

## Tujuan

* Menerapkan konsep **TDD (Red → Green → Refactor)**
* Membuat **unit testing menggunakan JUnit 5**
* Mengimplementasikan **business logic sesuai requirement**

---

## Struktur Project

```
p2p-lending/
├── pom.xml
├── src/
│   ├── main/java/com/p2p/
│   │   ├── domain/
│   │   │   ├── Borrower.java
│   │   │   ├── Lender.java
│   │   │   └── Loan.java
│   │   └── service/
│   │       ├── LoanService.java
│   │       └── FundingService.java
│   └── test/java/com/p2p/
│       ├── LoanServiceTest.java
│       ├── FundingServiceTest.java
│       └── LoanTest.java
```

---

## Teknologi

* Java
* Maven
* JUnit 5

---

## Alur Sistem

### 1. Loan Creation

* Borrower harus **terverifikasi (KYC)**
* Amount harus **> 0**
* Credit score menentukan:

  * ≥ 600 →  APPROVED
  * < 600 →  REJECTED

---

### 2. Funding

* Lender dapat mendanai loan
* Jika saldo tidak cukup → ditolak
* Jika dana terpenuhi → status → **FUNDED**

---

### 3. Disbursement (Activation)

* Loan hanya bisa diaktifkan jika:

  * status = FUNDED
* Setelah itu:

  * status → **ACTIVE**

---

### 4. Repayment

* Hanya bisa dilakukan jika status = ACTIVE
* Payment harus > 0
* Outstanding akan berkurang
* Jika lunas → status → **COMPLETED**

---

## Status Lifecycle

```
PENDING → APPROVED → FUNDED → ACTIVE → COMPLETED
                ↘
               REJECTED
```

---

## Testing (TDD)

### Loan Creation

* shouldRejectLoanWhenBorrowerNotVerified
* shouldRejectLoanWhenAmountIsZeroOrNegative
* shouldApproveLoanWhenCreditScoreHigh
* shouldRejectLoanWhenCreditScoreLow

### Funding

* shouldAllowFundingWhenBalanceSufficient
* shouldRejectFundingWhenBalanceNotEnough
* shouldMarkLoanAsFundedWhenFullyFunded

### Disbursement

* shouldNotActivateLoanIfNotFunded
* shouldActivateLoanWhenFunded

### Repayment

* shouldAllowRepaymentWhenLoanActive
* shouldRejectRepaymentWhenAmountInvalid
* shouldReduceOutstandingWhenRepay
* shouldCompleteLoanWhenOutstandingZero

---

## Cara Menjalankan

```bash
mvn clean test
```

Jika berhasil:

```
BUILD SUCCESS
```

---

## Highlight

* Menggunakan pendekatan **TDD**
* Memisahkan **domain logic & service**
* Menangani **edge cases**:

  * Invalid amount
  * Insufficient balance
  * Overpayment
  * Invalid state transition

---

## Kesimpulan

Project ini menunjukkan implementasi dasar sistem P2P Lending dengan:

* Struktur kode yang rapi
* Business rule yang jelas
* Pengujian yang lengkap

