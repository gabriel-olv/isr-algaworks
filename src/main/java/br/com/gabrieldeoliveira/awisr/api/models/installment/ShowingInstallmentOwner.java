package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowingInstallmentOwner {

    private Long id;
    private String name;
    private String email;

    public static ShowingInstallmentOwner fromEntity(Client entity) {
        ShowingInstallmentOwner owner = new ShowingInstallmentOwner();
        owner.setId(entity.getId());
        owner.setName(entity.getName());
        owner.setEmail(entity.getEmail());
        return owner;
    }
}
