package br.com.gabrieldeoliveira.awisr.api.models.client;

import br.com.gabrieldeoliveira.awisr.domain.models.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShowingClient {

    private Long id;
    private String name;
    private String email;
    private String phone;

    public static ShowingClient fromEntity(Client client) {
        return new ShowingClient(client.getId(), client.getName(), client.getEmail(),
                client.getPhone());
    }
}
