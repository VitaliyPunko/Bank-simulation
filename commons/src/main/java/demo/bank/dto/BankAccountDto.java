package demo.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class BankAccountDto {

    private Integer id;

    private String bankAccountNumber;
    private BigDecimal balance;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
    private ClientDto client;
    private BankCardDto bankCard;

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

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public BankCardDto getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCardDto bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountDto that = (BankAccountDto) o;
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

    @Override
    public String toString() {
        return "BankAccountDto{" +
                "id=" + id +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", balance=" + balance +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                ", client=" + client +
                '}';
    }
}
