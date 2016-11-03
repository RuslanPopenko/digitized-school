package ua.kpi.dreamteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.dreamteam.entities.Teacher;

/**
 * Created by Макс on 03.11.2016.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
