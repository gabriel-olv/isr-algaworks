package br.com.gabrieldeoliveira.awisr.api.resources;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.repositories.ClientRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientResource {

    private ClientRepository clientRepository;

    @GetMapping
    ResponseEntity<List<Client>> findAll() {
        List<Client> all = clientRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    ResponseEntity<Client> findById(@PathVariable Long id, HttpServletResponse response) {
        Optional<Client> found = clientRepository.findById(id);
        return found.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Client> deleteById(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> create(@RequestBody Client client, HttpServletRequest request) {
        Client created = clientRepository.save(client);
        URI uri = UriComponentsBuilder
                .fromUriString(request.getRequestURL().toString())
                .path("/{id}").buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
