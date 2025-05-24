package dev.springhandson.faunawildsphere.repository;

import dev.springhandson.faunawildsphere.entity.Tiger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TigerRepository extends JpaRepository<Tiger, Long> {}
