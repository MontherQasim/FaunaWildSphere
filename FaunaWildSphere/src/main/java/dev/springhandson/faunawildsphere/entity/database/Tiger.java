package dev.springhandson.faunawildsphere.entity.database;

import dev.springhandson.faunawildsphere.entity.behavior.Sprintable;
import dev.springhandson.faunawildsphere.entity.sound.Roarable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("TIGER")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Tiger extends Animal implements Sprintable, Roarable {

    @Column(name = "NumberOfCubs")
    private int numberOfCubs;

    @Column(name = "StripePattern")
    private String stripePattern;

    @Override
    public void sprint() {
        System.out.printf("Tiger '%s' with a %s stripe pattern darts through the jungle with silent, deadly speed.%n",
                getName(), stripePattern.toLowerCase());
    }

    @Override
    public void roar() {
        System.out.printf("Tiger '%s' unleashes a low, rumbling growl that echoes like thunder in the forest.%n",
                getName());
    }
}
