package dev.springhandson.faunawildsphere.entity;

import dev.springhandson.faunawildsphere.entity.base.AuditInfo;
import dev.springhandson.faunawildsphere.entity.type.HealthStatus;
import dev.springhandson.faunawildsphere.entity.type.LifeStatus;
import dev.springhandson.faunawildsphere.entity.type.Species;
import lombok.experimental.SuperBuilder;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;

@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "AnimalType", discriminatorType = DiscriminatorType.STRING)
@SuperBuilder
@ToString(exclude = {"biography", "deathDetails"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public abstract class Animal extends  AuditInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NonNull
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Species", nullable = false)
    @NonNull
    private Species species;

    @Column(name = "BOD", nullable = false, updatable = false)
    @NonNull
    private LocalDate bod;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    @NonNull
    private LifeStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "HealthStatus", nullable = false)
    @NonNull
    private HealthStatus healthStatus;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column( name = "Biography", columnDefinition = "TEXT")
    @Nullable
    private String biography;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "DeathDetails", columnDefinition = "TEXT", updatable = false, insertable = false)
    @Nullable
    private String deathDetails;

    @Transient
    public int getAge() {
        return Period.between(bod, LocalDate.now(Clock.systemDefaultZone())).getYears();
    }
}