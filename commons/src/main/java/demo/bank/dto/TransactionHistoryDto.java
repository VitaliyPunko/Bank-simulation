package demo.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionHistoryDto {

    private Integer id;
    private LocalDateTime transactionTime;
    private BigDecimal sum;
    private BankAccountDto bankAccountSender;
    private BankAccountDto bankAccountReceiver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transaction_time) {
        this.transactionTime = transaction_time;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BankAccountDto getBankAccountSender() {
        return bankAccountSender;
    }

    public void setBankAccountSender(BankAccountDto bankAccountSender) {
        this.bankAccountSender = bankAccountSender;
    }

    public BankAccountDto getBankAccountReceiver() {
        return bankAccountReceiver;
    }

    public void setBankAccountReceiver(BankAccountDto bankAccountReceiver) {
        this.bankAccountReceiver = bankAccountReceiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionHistoryDto that = (TransactionHistoryDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionTime, sum);
    }
}
