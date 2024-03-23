package br.com.gabrieldeoliveira.awisr.api.exceptions.models;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractError {

    private Instant timestamp;
    private Integer status;
    private String title;
    private String path;
}
