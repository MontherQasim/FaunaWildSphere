package dev.springhandson.faunawildsphere.repository.interfaceProjection;

import dev.springhandson.faunawildsphere.entity.database.Lion;
import dev.springhandson.faunawildsphere.projection.interfaceProjection.LionView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LionRepository2 extends JpaRepository<Lion, Long> {
//    @Query("""
//                SELECT l.id , l.name
//                FROM Lion l
//                WHERE l.name <> :name
//            """)
    @Query(value = """
            SELECT l.id, name
            FROM animal l
            WHERE l.nalme <> :name
            """,
            countQuery = "SELECT COUNT(*) FROM lion WHERE name <> :name",
            nativeQuery = true)
    <T>Page<T> findByName(@Param("name") String name, Pageable pageable, Class<T> type);
}