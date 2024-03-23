package br.com.gabrieldeoliveira.awisr.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tb_installment")
@NoArgsConstructor
@AllArgsConstructor
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant date;

    @Column(length = 150, nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer installments;

    @Column(nullable = false)
    private BigDecimal totalValue;

    @ManyToOne
    private Client owner;

    public void updateWith(Installment newData) {
        if (Objects.nonNull(newData.description) && !newData.description.isBlank())
            description = newData.description;
    }
}
