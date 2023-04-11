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
    private ClientDto clientDto;
    private BankCardDto bankCardDto;

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

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public BankCardDto getBankCardDto() {
        return bankCardDto;
    }

    public void setBankCardDto(BankCardDto bankCardDto) {
        this.bankCardDto = bankCardDto;
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
}
