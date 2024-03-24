package br.com.gabrieldeoliveira.awisr.api.models.client;

import br.com.gabrieldeoliveira.awisr.api.models.validation.Phone;
import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class NewClient {

    @NotNull
    @Length(max = 50)
    private String name;

    @NotNull
    @Length(max = 50)
    private String email;

    @NotNull
    @Phone
    private String phone;

    public Client toEntity() {
        return new Client(null, name, email, phone);
    }
}
