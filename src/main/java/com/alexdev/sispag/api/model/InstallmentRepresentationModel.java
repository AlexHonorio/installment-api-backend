package com.alexdev.sispag.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Getter
@Setter
public class InstallmentRepresentationModel {

    private Long id;
    //private String client_name;
    private ClientSummaryModel client;
    private String description;
    private BigDecimal total_value;
    private Integer installments;
    private OffsetDateTime date_creation;

}
