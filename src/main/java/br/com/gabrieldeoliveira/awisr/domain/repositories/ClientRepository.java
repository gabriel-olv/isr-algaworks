package br.com.gabrieldeoliveira.awisr.domain.repositories;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
