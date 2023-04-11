package demo.bank.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "bank")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_client_generator")
    @SequenceGenerator(name = "bank_client_generator", sequenceName = "bank.bank_clients_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "year_of_birth")
    private LocalDate yearOfBirth;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "registration")
    private String registration;

    @OneToMany(mappedBy = "client")
    private List<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "client")
    private List<BankCard> bankCards;

    public Client() {
    }

    public Client(String lastName,
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


    public void addBankAccountToClient(BankAccount bankAccount) {
        if (bankAccounts == null) {
            bankAccounts = new ArrayList<>();
        }
        bankAccount.setClient(this);
        bankAccounts.add(bankAccount);
    }

    public void addBankCardToClient(BankCard bankCard) {
        if (bankCards == null) {
            bankCards = new ArrayList<>();
        }
        bankCard.setClient(this);
        bankCards.add(bankCard);
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

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
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
}
