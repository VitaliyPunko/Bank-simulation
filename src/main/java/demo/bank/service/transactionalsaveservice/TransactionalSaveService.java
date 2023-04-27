package demo.bank.service.transactionalsaveservice;

import demo.bank.dto.BankAccountDto;

import java.math.BigDecimal;

public interface TransactionalSaveService {

    void transferMoney(BigDecimal paymentSum, BankAccountDto bankAccountReceiver, BankAccountDto bankAccountSender);
}
