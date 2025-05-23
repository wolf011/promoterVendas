package org.serratec.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LancamentoVendasRequestDTO {

    @CurrentTimestamp
    private LocalDateTime dataVenda;

    @Positive
    private BigDecimal valorVenda;

    @NotBlank
    private String nomeVendedor;
}
