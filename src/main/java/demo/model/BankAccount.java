package demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bank_accounts", schema = "bank")
public class BankAccount {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_account_generator")
    @SequenceGenerator(name="bank_account_generator", sequenceName = "bank_accounts_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "open_date")
    private LocalDateTime openDate;

    @Column(name = "close_date")
    private LocalDateTime closeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bankAccountNumber, that.bankAccountNumber) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(openDate, that.openDate) &&
                Objects.equals(closeDate, that.closeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankAccountNumber, balance, openDate, closeDate);
    }
}
