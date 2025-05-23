package org.serratec.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.serratec.backend.entity.Vendedor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LancamentoVendasRequestDTO {

    @CreationTimestamp
    private LocalDateTime dataVenda;

    @Positive
    private BigDecimal valorVenda;

    @NotBlank
    private Vendedor vendedor;

}
