package demo.bank.service.transactionalsaveservice;

import demo.bank.dto.BankAccountDto;
import demo.bank.service.bankaccount.BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionalSaveServiceImpl implements TransactionalSaveService {

    private final BankAccountService bankAccountService;

    public TransactionalSaveServiceImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transferMoney(BigDecimal paymentSum, BankAccountDto bankAccountReceiver, BankAccountDto bankAccountSender) {
        bankAccountReceiver.setBalance(bankAccountReceiver.getBalance().subtract(paymentSum));
        bankAccountSender.setBalance(bankAccountSender.getBalance().add(paymentSum));
        bankAccountService.createOrUpdateBankAccount(bankAccountReceiver);
        String a = null;
        a.toString();
        bankAccountService.createOrUpdateBankAccount(bankAccountSender);
    }
}
