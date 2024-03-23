package br.com.gabrieldeoliveira.awisr.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tb_client")
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(
            length = 50,
            nullable = false,
            unique = true)
    private String email;

    @Column(length = 11, nullable = false)
    private String phone;

    public void updateWith(Client newData) {
        if (Objects.nonNull(newData.email) && !newData.email.isBlank())
            email = newData.email;
        if (Objects.nonNull(newData.phone) && !newData.phone.isBlank())
            phone = newData.phone;
    }
}
