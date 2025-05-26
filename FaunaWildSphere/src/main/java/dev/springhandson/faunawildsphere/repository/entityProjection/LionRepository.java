package dev.springhandson.faunawildsphere.repository.entityProjection;

import dev.springhandson.faunawildsphere.entity.database.Lion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LionRepository extends JpaRepository<Lion, Long> {
}