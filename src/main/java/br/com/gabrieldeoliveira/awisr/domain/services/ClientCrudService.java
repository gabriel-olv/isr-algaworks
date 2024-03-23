package br.com.gabrieldeoliveira.awisr.domain.services;

import br.com.gabrieldeoliveira.awisr.domain.EntityNotFoundException;
import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientCrudService {

    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
    }

    @Transactional
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClientWithId(Long id, Client newData) {
        Client found = findById(id);
        found.updateWith(newData);
        return found;
    }
}
