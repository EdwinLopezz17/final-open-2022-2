package com.ecodriver.platform.u20201b772.behaviour.domain.model;

import com.ecodriver.platform.u20201b772.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scores")
public class Score extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long driverId;

    @NotNull
    private Float value;

}