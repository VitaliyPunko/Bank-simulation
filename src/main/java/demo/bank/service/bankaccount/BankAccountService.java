package demo.bank.service.bankaccount;

import demo.bank.dto.BankAccountDto;

public interface BankAccountService {

    BankAccountDto findBankAccountById(Integer accountId);

    BankAccountDto findBankAccountByNumber(String bankAccountNumber);

    BankAccountDto createOrUpdateBankAccount(BankAccountDto bankAccountDto);

    String closeBankAccount(Integer accountId);
}
