package com.alexdev.sispag.api.model.input;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class InstallmentInput {

    @NotBlank
    @Size(max = 20)
    private String description;

    @NotNull
    @Positive
    private BigDecimal total_value;

    @NotNull
    @Positive
    @Max(12)
    private Integer installments;

    @Valid
    @NotNull
    private clientIdInput client;
}
