package com.alexdev.sispag.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class clientIdInput {

    @NotNull
    private Long id;

}
