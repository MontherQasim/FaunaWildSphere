package dev.springhandson.faunawildsphere.config;

import dev.springhandson.faunawildsphere.entity.database.Lion;
import dev.springhandson.faunawildsphere.entity.database.Tiger;
import dev.springhandson.faunawildsphere.entity.type.HealthStatus;
import dev.springhandson.faunawildsphere.entity.type.LifeStatus;
import dev.springhandson.faunawildsphere.entity.type.Species;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {

    @Bean
    public Lion lionBean() {
        return Lion.builder()
                .name("Simba")
                .species(Species.MAMMAL)
                .bod(LocalDate.of(2018, 3, 15))
                .status(LifeStatus.ALIVE)
                .healthStatus(HealthStatus.HEALTHY)
                .numberOfCubs(3)
                .alpha(true)
                .build();
    }

    @Bean
    public Tiger tigerBean() {
        return Tiger.builder()
                .name("Shere Khan")
                .species(Species.MAMMAL)
                .bod(LocalDate.of(2016, 8, 10))
                .status(LifeStatus.ALIVE)
                .healthStatus(HealthStatus.HEALTHY)
                .numberOfCubs(2)
                .stripePattern("Bold Dark Stripes")
                .build();
    }
}
