package br.com.gabrieldeoliveira.awisr.api.resources;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import br.com.gabrieldeoliveira.awisr.domain.services.InstallmentCrudService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/installments")
@AllArgsConstructor
public class InstallmentResource {

    private InstallmentCrudService installmentCrudService;

    @GetMapping
    ResponseEntity<List<Installment>> findAll() {
        List<Installment> all = installmentCrudService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    ResponseEntity<Installment> findById(@PathVariable Long id) {
        Installment found = installmentCrudService.findById(id);
        return ResponseEntity.ok(found);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id) {
        installmentCrudService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Installment> updateById(@PathVariable Long id, @RequestBody Installment newData) {
        Installment updated = installmentCrudService.updateWith(id, newData);
        return ResponseEntity.ok(updated);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> create(@RequestBody Installment installment, HttpServletRequest request) {
        Installment created = installmentCrudService.create(installment);
        URI uri = UriComponentsBuilder
                .fromUriString(request.getRequestURL().toString())
                .path("/{id}").buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
