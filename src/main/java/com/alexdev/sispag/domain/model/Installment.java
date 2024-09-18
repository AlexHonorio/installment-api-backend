package com.alexdev.sispag.domain.model;

import com.alexdev.sispag.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "parcelamento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    @NotNull
    @ManyToOne
    private Client client;

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
    private OffsetDateTime date_creation;

}
