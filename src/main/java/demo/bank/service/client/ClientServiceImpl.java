package demo.bank.service.client;

import demo.bank.dao.ClientRepository;
import demo.bank.dto.ClientDto;
import demo.bank.mapper.ClientMapper;
import demo.bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void createClient(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        clientRepository.save(client);
    }
}
