package dev.springhandson.faunawildsphere.repository.entityProjection;

import dev.springhandson.faunawildsphere.entity.database.Tiger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TigerRepository extends JpaRepository<Tiger, Long> {

}