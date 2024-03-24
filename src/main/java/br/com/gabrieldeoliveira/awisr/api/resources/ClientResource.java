package br.com.gabrieldeoliveira.awisr.api.resources;

import br.com.gabrieldeoliveira.awisr.api.models.client.NewClient;
import br.com.gabrieldeoliveira.awisr.api.models.client.ShowingClient;
import br.com.gabrieldeoliveira.awisr.api.models.client.UpdateClient;
import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.services.ClientCrudService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientResource {

    private ClientCrudService clientCrudService;

    @GetMapping
    ResponseEntity<List<ShowingClient>> findAll() {
        List<ShowingClient> all = clientCrudService.findAll().stream()
                .map(ShowingClient::fromEntity).toList();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    ResponseEntity<ShowingClient> findById(@PathVariable Long id) {
        Client found = clientCrudService.findById(id);
        return ResponseEntity.ok(ShowingClient.fromEntity(found));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clientCrudService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<ShowingClient> updateById(@PathVariable Long id, @RequestBody @Valid UpdateClient newData) {
        Client updated = clientCrudService.updateWith(id, newData.toEntity());
        return ResponseEntity.ok(ShowingClient.fromEntity(updated));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> create(@RequestBody @Valid NewClient newClient, HttpServletRequest request) {
        Client created = clientCrudService.create(newClient.toEntity());
        URI uri = UriComponentsBuilder
                .fromUriString(request.getRequestURL().toString())
                .path("/{id}").buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
