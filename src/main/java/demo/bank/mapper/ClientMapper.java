package demo.bank.mapper;

import demo.bank.dto.ClientDto;
import demo.bank.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  ClientMapper {

    ClientDto toDto(Client client);
    Client toEntity(ClientDto clientDto);
}
