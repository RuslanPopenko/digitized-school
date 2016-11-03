package ua.kpi.dreamteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.dreamteam.entities.Subject;

/**
 * Created by yevhenii on 03.11.16.
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
