package br.com.gabrieldeoliveira.awisr.api.models.client;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateClient {

    private String email;
    private String phone;

    public Client toEntity() {
        return new Client(null, null, email, phone);
    }
}
