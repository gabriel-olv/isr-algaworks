package br.com.gabrieldeoliveira.awisr.api.resources;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.repositories.ClientRepository;
import br.com.gabrieldeoliveira.awisr.domain.services.ClientCrudService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientResource {

    private ClientCrudService clientCrudService;

    @GetMapping
    ResponseEntity<List<Client>> findAll() {
        List<Client> all = clientCrudService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    ResponseEntity<Client> findById(@PathVariable Long id, HttpServletResponse response) {
        Client found = clientCrudService.findById(id);
        return ResponseEntity.ok(found);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Client> deleteById(@PathVariable Long id) {
        clientCrudService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Client> deleteById(@PathVariable Long id, @RequestBody Client newData) {
        Client updated = clientCrudService.updateClientWithId(id, newData);
        return ResponseEntity.ok(updated);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> create(@RequestBody Client client, HttpServletRequest request) {
        Client created = clientCrudService.create(client);
        URI uri = UriComponentsBuilder
                .fromUriString(request.getRequestURL().toString())
                .path("/{id}").buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
