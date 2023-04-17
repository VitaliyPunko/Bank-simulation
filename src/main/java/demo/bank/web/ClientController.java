package demo.bank.web;

import demo.bank.dto.ClientDto;
import demo.bank.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @GetMapping("/find/{id}")
    public ClientDto findClient(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @PutMapping("/update")
    public ClientDto updateClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClientById(@PathVariable Integer id) {
        clientService.deleteClientById(id);
    }

}
