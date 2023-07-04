package com.ecodriver.platform.u20201b772.behaviour.resource;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateScoreResource {


    @NotNull
    private Float value;
}
