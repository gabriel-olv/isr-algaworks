package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.api.models.OutputModel;
import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowingInstallmentOwner implements OutputModel<Client> {

    private Long id;
    private String name;
    private String email;

    @Override
    public ShowingInstallmentOwner fromEntity(Client entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        return this;
    }
}
