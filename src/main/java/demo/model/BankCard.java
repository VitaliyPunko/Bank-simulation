package demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "bank_cards", schema = "bank")
public class BankCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_cards_generator")
    @SequenceGenerator(name="bank_cards_generator", sequenceName = "bank_cards_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "bank_card_number")
    private String bankCardNumber;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "close_date")
    private LocalDate closeDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
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
