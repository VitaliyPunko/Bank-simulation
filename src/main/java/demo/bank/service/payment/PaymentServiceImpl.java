package demo.bank.service.payment;

import demo.bank.core.Payment;
import demo.bank.dto.BankAccountDto;
import demo.bank.service.TransactionalSaveService.TransactionalSaveService;
import demo.bank.service.bankaccount.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final BankAccountService bankAccountService;
    private TransactionalSaveService transactionalSaveService;

    public PaymentServiceImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    //TODO: использовать паттерн какой-то. Цепочку
    @Override
//    @Transactional
    public String doPayment(Payment payment) {
        String bankAccountNumberReceiver = payment.getBankAccountNumberReceiver();
        String bankAccountNumberSender = payment.getBankAccountNumberSender();

        BankAccountDto bankAccountReceiver = bankAccountService.findBankAccountByNumber(bankAccountNumberReceiver);
        //TODO: make if bankAccountSender not exists
        BankAccountDto bankAccountSender = bankAccountService.findBankAccountByNumber(bankAccountNumberSender);

        boolean isBalanceMoreThanPaymentValue = checkIfSumMoreThanPaymentValue(payment, bankAccountReceiver);
        if (!isBalanceMoreThanPaymentValue) {
            logger.warn("Account: {} has a negative balance. Cannot do a payment", bankAccountNumberReceiver);
            return "Account: " + bankAccountNumberReceiver + " has a negative balance. Cannot do a payment";
        }


//        transferMoney(payment.getSum(), bankAccountReceiver, bankAccountSender);

        //TODO: так уже работает
        BigDecimal paymentSum = payment.getSum();
//        bankAccountReceiver.setBalance(bankAccountReceiver.getBalance().subtract(paymentSum));
//        bankAccountSender.setBalance(bankAccountSender.getBalance().add(paymentSum));
//        bankAccountService.createOrUpdateBankAccount(bankAccountReceiver);
//        String a = null;
//        a.toString();
//        bankAccountService.createOrUpdateBankAccount(bankAccountSender);

        transactionalSaveService.transferMoney(paymentSum, bankAccountReceiver, bankAccountSender);
        return "Payment was transferred successfully!";
    }

    //все равно создается транзакция на каждый save method
    //TODO: так не работает? потому что вызывается этот метод в методе выше?
//    @Transactional(rollbackFor = Exception.class)
//    public void transferMoney(BigDecimal paymentSum, BankAccountDto bankAccountReceiver, BankAccountDto bankAccountSender) {
//        bankAccountReceiver.setBalance(bankAccountReceiver.getBalance().subtract(paymentSum));
//        bankAccountSender.setBalance(bankAccountSender.getBalance().add(paymentSum));
//        bankAccountService.createOrUpdateBankAccount(bankAccountReceiver);
//        String a = null;
//        a.toString();
//        bankAccountService.createOrUpdateBankAccount(bankAccountSender);
//    }

    private boolean checkIfSumMoreThanPaymentValue(Payment payment, BankAccountDto bankAccountReceiver) {
        BigDecimal balance = bankAccountReceiver.getBalance();
        return balance.compareTo(payment.getSum()) > 0;
    }

    @Autowired
    public void setTransactionalSaveService(TransactionalSaveService transactionalSaveService) {
        this.transactionalSaveService = transactionalSaveService;
    }
}
