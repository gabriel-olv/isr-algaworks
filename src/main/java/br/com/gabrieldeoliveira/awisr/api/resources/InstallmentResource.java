package br.com.gabrieldeoliveira.awisr.api.resources;

import br.com.gabrieldeoliveira.awisr.api.models.installment.NewInstallment;
import br.com.gabrieldeoliveira.awisr.api.models.installment.ShowingInstallment;
import br.com.gabrieldeoliveira.awisr.api.models.installment.UpdateInstallment;
import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import br.com.gabrieldeoliveira.awisr.domain.services.InstallmentCrudService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/installments")
@AllArgsConstructor
public class InstallmentResource {

    private InstallmentCrudService installmentCrudService;

    @GetMapping
    ResponseEntity<List<ShowingInstallment>> findAll() {
        List<ShowingInstallment> all = installmentCrudService.findAll()
                .stream().map(ShowingInstallment::fromEntity).toList();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    ResponseEntity<ShowingInstallment> findById(@PathVariable Long id) {
        Installment found = installmentCrudService.findById(id);
        return ResponseEntity.ok(ShowingInstallment.fromEntity(found));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id) {
        installmentCrudService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<ShowingInstallment> updateById(@PathVariable Long id, @RequestBody @Valid UpdateInstallment newData) {
        Installment updated = installmentCrudService.updateWith(id, newData.toEntity());
        return ResponseEntity.ok(ShowingInstallment.fromEntity(updated));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> create(@RequestBody @Valid NewInstallment newInstallment, HttpServletRequest request) {
        Installment created = installmentCrudService.create(newInstallment.toEntity());
        URI uri = URI.create(request.getRequestURL().toString() + "/" + created.getId());
        return ResponseEntity.created(uri).build();
    }
}
