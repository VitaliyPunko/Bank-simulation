package demo.bank.service.client;

import demo.bank.dao.ClientRepository;
import demo.bank.dto.ClientDto;
import demo.bank.mapper.ClientMapper;
import demo.bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;


    @Autowired
    public ClientServiceImpl(ClientMapper clientMapper,
                             ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto findById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.map(clientMapper::toDto).orElse(null);
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        Client saved = clientRepository.save(client);
        return clientMapper.toDto(saved);
    }

    @Override
    public void deleteClientById(Integer id) {
        clientRepository.deleteById(id);
    }
}
