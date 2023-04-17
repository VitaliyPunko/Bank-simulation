package demo.bank.mapper;

import demo.bank.dto.BankAccountDto;
import demo.bank.model.BankAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    BankAccountDto toDto(BankAccount bankAccount);

    BankAccount toEntity(BankAccountDto bankAccountDto);
}
