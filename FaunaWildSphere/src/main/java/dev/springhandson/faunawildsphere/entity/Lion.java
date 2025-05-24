package dev.springhandson.faunawildsphere.entity;

import dev.springhandson.faunawildsphere.entity.behavior.Sprintable;
import dev.springhandson.faunawildsphere.entity.sound.Roarable;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("LION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lion extends Animal implements Sprintable, Roarable {

    @Column(name = "NumberOfCubs", nullable = false)
    private int numberOfCubs;

    @Column(name = "IsAlpha", nullable = false)
    private boolean alpha;

    @Override
    public void sprint() {
        String role = alpha ? "Alpha" : "Lion";
        System.out.printf("%s '%s' bursts into a powerful sprint, leaving a trail of dust behind!%n", role, getName());
    }

    @Override
    public void roar() {
        String volume = alpha ? "dominant and earth-shaking" : "deep and commanding";
        System.out.printf("Lion '%s' roars with a %s sound that sends chills through the savannah.%n", getName(), volume);
    }
}