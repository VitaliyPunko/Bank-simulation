package demo.bank.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ClientDto {

    private Integer id;
    private String lastName;
    private String firstName;
    private LocalDate yearOfBirth;
    private String citizenship;
    private String registration;

    private List<BankAccountDto> bankAccount;
    private List<BankCardDto> bankCard;

    public ClientDto() {
    }

    public ClientDto(String lastName,
                     String firstName,
                     LocalDate yearOfBirth,
                     String citizenship,
                     String registration) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.citizenship = citizenship;
        this.registration = registration;
    }

    public void addBankAccountToClient(BankAccountDto bankAccount) {
        if (this.bankAccount == null) {
            this.bankAccount = new ArrayList<>();
        }
        bankAccount.setClient(this);
        this.bankAccount.add(bankAccount);
    }

    public void addBankCardToClient(BankCardDto bankCardDto) {
        if (bankCard == null) {
            bankCard = new ArrayList<>();
        }
        bankCardDto.setClientDto(this);
        bankCard.add(bankCardDto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public List<BankAccountDto> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<BankAccountDto> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<BankCardDto> getBankCard() {
        return bankCard;
    }

    public void setBankCard(List<BankCardDto> bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto client = (ClientDto) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(yearOfBirth, client.yearOfBirth) &&
                Objects.equals(citizenship, client.citizenship) &&
                Objects.equals(registration, client.registration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, yearOfBirth, citizenship, registration);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", citizenship='" + citizenship + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
