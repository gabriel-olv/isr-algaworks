package br.com.gabrieldeoliveira.awisr.api.models.client;

import br.com.gabrieldeoliveira.awisr.api.models.validation.Phone;
import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class UpdateClient {

    @NotNull
    @Length(max = 50)
    private String email;

    @NotNull
    @Phone
    private String phone;

    public Client toEntity() {
        return new Client(null, null, email, phone);
    }
}
