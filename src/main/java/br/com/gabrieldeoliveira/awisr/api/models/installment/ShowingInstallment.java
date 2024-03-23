package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.api.models.OutputModel;
import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import br.com.gabrieldeoliveira.awisr.domain.utils.DateFormatter;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ShowingInstallment implements OutputModel<Installment> {

    private Long id;
    private String date;
    private String description;
    private Integer installments;
    private BigDecimal totalValue;
    private ShowingInstallmentOwner owner;

    @Override
    public ShowingInstallment fromEntity(Installment entity) {
        id = entity.getId();
        date = DateFormatter.formatInstantOnPattern(entity.getDate(), "dd/MM/yyyy HH:mm:ss");
        description = entity.getDescription();
        installments = entity.getInstallments();
        totalValue = entity.getTotalValue();
        owner = new ShowingInstallmentOwner().fromEntity(entity.getOwner());
        return this;
    }
}
