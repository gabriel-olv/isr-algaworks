package br.com.gabrieldeoliveira.awisr.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
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
}
