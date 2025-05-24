package dev.springhandson.faunawildsphere.repository;

import dev.springhandson.faunawildsphere.entity.Lion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LionRepository extends JpaRepository<Lion, Long> {}
