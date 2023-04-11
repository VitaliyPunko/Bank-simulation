package demo.bank.dto;


import java.time.LocalDate;
import java.util.Objects;


public class BankCardDto {

    private Integer id;
    private String bankCardNumber;
    private LocalDate openDate;
    private LocalDate closeDate;
    private ClientDto clientDto;
    private BankAccountDto bankAccountDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public BankAccountDto getBankAccountDto() {
        return bankAccountDto;
    }

    public void setBankAccountDto(BankAccountDto bankAccountDto) {
        this.bankAccountDto = bankAccountDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCardDto bankCard = (BankCardDto) o;
        return Objects.equals(id, bankCard.id) &&
                Objects.equals(bankCardNumber, bankCard.bankCardNumber) &&
                Objects.equals(openDate, bankCard.openDate) &&
                Objects.equals(closeDate, bankCard.closeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankCardNumber, openDate, closeDate);
    }
}
