package demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transactions_history", schema = "bank")
public class TransactionHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_transactions_history_generator")
    @SequenceGenerator(name="bank_transactions_history_generator", sequenceName = "bank_transactions_history_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

    @Column(name = "sum")
    private BigDecimal sum;

    @OneToOne
    @JoinColumn(name = "bank_account_sender_id")
    private BankAccount bankAccountSender;

    @OneToOne
    @JoinColumn(name = "bank_account_receiver_id")
    private BankAccount bankAccountReceiver;

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

    public BankAccount getBankAccountSender() {
        return bankAccountSender;
    }

    public void setBankAccountSender(BankAccount bankAccountSender) {
        this.bankAccountSender = bankAccountSender;
    }

    public BankAccount getBankAccountReceiver() {
        return bankAccountReceiver;
    }

    public void setBankAccountReceiver(BankAccount bankAccountReceiver) {
        this.bankAccountReceiver = bankAccountReceiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionHistory that = (TransactionHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionTime, sum);
    }
}
