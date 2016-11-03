package ua.kpi.dreamteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.dreamteam.entities.SchoolClass;

/**
 * Created by yevhenii on 03.11.16.
 */
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}
