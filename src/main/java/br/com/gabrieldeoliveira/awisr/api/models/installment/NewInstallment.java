package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.api.models.InputModel;
import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class NewInstallment implements InputModel<Installment> {

    private String description;
    private Integer installments;
    private BigDecimal totalValue;
    private Long ownerId;

    @Override
    public Installment toEntity() {
        Client owner = new Client();
        owner.setId(ownerId);

        return new Installment(null, null, description, installments,
                totalValue, owner);
    }
}
