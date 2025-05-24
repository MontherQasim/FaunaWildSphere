package dev.springhandson.faunawildsphere.entity;

import dev.springhandson.faunawildsphere.entity.behavior.Sprintable;
import dev.springhandson.faunawildsphere.entity.sound.Roarable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("LION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Lion extends Animal implements Sprintable, Roarable {

    @Column(name = "NumberOfCubs")
    private int numberOfCubs;

    @Column(name = "IsAlpha")
    private boolean alpha;

    @Override
    public void sprint() {
        String role = alpha ? "Alpha lion" : "Lion";
        System.out.printf("%s '%s' charges forward with raw power, asserting dominance over the plains.%n",
                role, getName());
    }

    @Override
    public void roar() {
        String style = alpha ? "a thunderous, pride-rallying roar" : "a bold and fierce growl";
        System.out.printf("%s '%s' roars with %s that claims the savannah as its kingdom.%n",
                alpha ? "Alpha lion" : "Lion", getName(), style);
    }
}