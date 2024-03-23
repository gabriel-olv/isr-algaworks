package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.api.models.InputModel;
import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateInstallment implements InputModel<Installment> {

    private String description;

    @Override
    public Installment toEntity() {
        return new Installment(null, null, description, null, null, null);
    }
}
