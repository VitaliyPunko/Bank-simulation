package demo.bank.service.client;

import demo.bank.dto.ClientDto;

public interface ClientService {

    ClientDto findById(Integer id);

    ClientDto createClient(ClientDto clientDto);

    void deleteClientById(Integer id);
}
