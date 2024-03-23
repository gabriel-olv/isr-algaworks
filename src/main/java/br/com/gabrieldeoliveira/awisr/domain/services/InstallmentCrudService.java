package br.com.gabrieldeoliveira.awisr.domain.services;

import br.com.gabrieldeoliveira.awisr.domain.exceptions.BadRequestException;
import br.com.gabrieldeoliveira.awisr.domain.exceptions.EntityNotFoundException;
import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import br.com.gabrieldeoliveira.awisr.domain.repositories.InstallmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class InstallmentCrudService {

    private InstallmentRepository installmentRepository;
    private ClientCrudService clientCrudService;

    @Transactional(readOnly = true)
    public List<Installment> findAll() {
        return installmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Installment findById(Long id) {
        return installmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Installment not found with id " + id));
    }

    @Transactional
    public void deleteById(Long id) {
        installmentRepository.deleteById(id);
    }

    @Transactional
    public Installment create(Installment installment) {
        installment.setDate(Instant.now());
        try {
            clientCrudService.findById(installment.getOwner().getId());
        } catch (EntityNotFoundException ex) {
            throw new BadRequestException(ex.getMessage());
        }
        return installmentRepository.save(installment);
    }

    @Transactional
    public Installment updateWith(Long id, Installment newData) {
        Installment found = findById(id);
        found.updateWith(newData);
        return found;
    }
}
