package demo.bank.web;

import demo.bank.dto.BankAccountDto;
import demo.bank.service.bankaccount.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final static Logger logger = LoggerFactory.getLogger(BankAccountController.class);

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/find/{id}")
    public BankAccountDto findBankAccountById(@PathVariable Integer id) {
        logger.debug("findBankAccountById method of BankAccountController was called");
        return bankAccountService.findBankAccountById(id);
    }

    @PostMapping("/save")
    public BankAccountDto createBankAccount(@RequestBody BankAccountDto bankAccountDto) {
        logger.debug("createBankAccount method of BankAccountController was called");
        return bankAccountService.createOrUpdateBankAccount(bankAccountDto);
    }

    @PutMapping("/update")
    public BankAccountDto updateBankAccount(@RequestBody BankAccountDto bankAccountDto) {
        logger.debug("updateBankAccount method of BankAccountController was called");
        return bankAccountService.createOrUpdateBankAccount(bankAccountDto);
    }

    @DeleteMapping("/delete/{id}")
    public String closeBankAccount(@PathVariable Integer id) {
        logger.debug("closeBankAccount method of BankAccountController was called");
        return bankAccountService.closeBankAccount(id);
    }
}
