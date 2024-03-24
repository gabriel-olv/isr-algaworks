package br.com.gabrieldeoliveira.awisr.api.models.installment;

import br.com.gabrieldeoliveira.awisr.domain.models.Installment;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class UpdateInstallment {

    @NotNull
    @Length(max = 150)
    private String description;
    
    public Installment toEntity() {
        return new Installment(null, null, description, null, null, null);
    }
}
