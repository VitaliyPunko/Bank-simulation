package demo.bank.core;

import java.math.BigDecimal;

public class Payment {

    private String bankAccountNumberSender;
    private String bankAccountNumberReceiver;
    private BigDecimal sum;

    public Payment() {
    }

    public Payment(String bankAccountNumberSender,
                   String bankAccountNumberReceiver,
                   BigDecimal sum) {
        this.bankAccountNumberSender = bankAccountNumberSender;
        this.bankAccountNumberReceiver = bankAccountNumberReceiver;
        this.sum = sum;
    }

    public String getBankAccountNumberSender() {
        return bankAccountNumberSender;
    }

    public void setBankAccountNumberSender(String bankAccountNumberSender) {
        this.bankAccountNumberSender = bankAccountNumberSender;
    }

    public String getBankAccountNumberReceiver() {
        return bankAccountNumberReceiver;
    }

    public void setBankAccountNumberReceiver(String bankAccountNumberReceiver) {
        this.bankAccountNumberReceiver = bankAccountNumberReceiver;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

}
