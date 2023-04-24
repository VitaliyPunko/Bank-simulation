package demo.bank.service.bankaccount;

import demo.bank.dao.BankAccountRepository;
import demo.bank.dto.BankAccountDto;
import demo.bank.mapper.BankAccountMapper;
import demo.bank.model.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final static Logger logger = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    private final BankAccountMapper bankAccountMapper;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountMapper bankAccountMapper,
                                  BankAccountRepository bankAccountRepository) {
        this.bankAccountMapper = bankAccountMapper;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountDto findBankAccountById(Integer accountId) {
        Optional<BankAccount> byId = bankAccountRepository.findById(accountId);
        BankAccount bankAccount = byId.orElseThrow();
        return bankAccountMapper.toDto(bankAccount);
    }

    @Override
    public BankAccountDto createOrUpdateBankAccount(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = bankAccountMapper.toEntity(bankAccountDto);
        BankAccount saved = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.toDto(saved);
    }

    @Override
    public String closeBankAccount(Integer accountId) {
        Optional<BankAccount> byId = bankAccountRepository.findById(accountId);
        BankAccount bankAccount = byId.orElseThrow();
        BankAccountDto bankAccountDto = bankAccountMapper.toDto(bankAccount);
        if (bankAccountDto.getBalance().compareTo(new BigDecimal(0)) > 0) {
            logger.debug("Account has a positive balance");
            bankAccountRepository.delete(bankAccount);
            return "Your bank account was successfully closed";
        } else {
            logger.debug("Account has a negative balance");
            return "You have negative sum of money on yours bank account. Please pay off the debt first";
        }
    }
}
