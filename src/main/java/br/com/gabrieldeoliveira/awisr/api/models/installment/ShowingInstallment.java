package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import br.com.gabrieldeoliveira.awisr.domain.utils.DateFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ShowingInstallment {

    private Long id;
    private String date;
    private String description;
    private Integer installments;
    private BigDecimal totalValue;
    private ShowingInstallmentOwner owner;

    public static ShowingInstallment fromEntity(Installment entity) {
        ShowingInstallment installment = new ShowingInstallment();
        installment.setId(entity.getId());
        installment.setDate(
                DateFormatter.formatInstantOnPattern(entity.getDate(), "dd/MM/yyyy HH:mm:ss"));
        installment.setDescription(entity.getDescription());
        installment.setInstallments(entity.getInstallments());
        installment.setTotalValue(entity.getTotalValue());
        installment.setOwner(ShowingInstallmentOwner.fromEntity(entity.getOwner()));
        return installment;
    }
}
