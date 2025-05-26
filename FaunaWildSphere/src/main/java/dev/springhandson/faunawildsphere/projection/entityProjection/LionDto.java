package dev.springhandson.faunawildsphere.projection.entityProjection;

import dev.springhandson.faunawildsphere.entity.type.HealthStatus;
import dev.springhandson.faunawildsphere.entity.type.LifeStatus;
import dev.springhandson.faunawildsphere.entity.type.Species;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LionDto {
    private Long id;
    private String name;
    private Species species;
    private LocalDate bod;
    private LifeStatus status;
    private HealthStatus healthStatus;
    private String biography;
    private int numberOfCubs;
    private boolean alpha;
}
