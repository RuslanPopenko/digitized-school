package ua.kpi.dreamteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.dreamteam.entities.School;

/**
 * Created by yevhenii on 03.11.16.
 */
public interface SchoolRepository extends JpaRepository<School, Long> {
}
