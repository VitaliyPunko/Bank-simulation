package demo.bank.web;

import demo.bank.dto.BankAccountDto;
import demo.bank.service.bankaccount.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/save")
    public BankAccountDto createBankAccount(@RequestBody BankAccountDto bankAccountDto) {
        return bankAccountService.createBankAccount(bankAccountDto);
    }
}
