package demo.bank.service.bankaccount;

import demo.bank.dao.BankAccountRepository;
import demo.bank.dto.BankAccountDto;
import demo.bank.mapper.BankAccountMapper;
import demo.bank.model.BankAccount;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountMapper bankAccountMapper;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountMapper bankAccountMapper,
                                  BankAccountRepository bankAccountRepository) {
        this.bankAccountMapper = bankAccountMapper;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountDto createBankAccount(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = bankAccountMapper.toEntity(bankAccountDto);
        BankAccount saved = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.toDto(saved);
    }
}
