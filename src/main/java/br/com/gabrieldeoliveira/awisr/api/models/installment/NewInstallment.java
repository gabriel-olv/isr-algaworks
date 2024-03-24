package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class NewInstallment {

    @NotNull
    @Length(max = 150)
    private String description;

    @NotNull
    @Max(value = 12)
    private Integer installments;

    @NotNull
    @Min(value = 120)
    private BigDecimal totalValue;

    @NotNull
    private Long ownerId;

    public Installment toEntity() {
        Client owner = new Client();
        owner.setId(ownerId);

        return new Installment(null, null, description, installments,
                totalValue, owner);
    }
}
