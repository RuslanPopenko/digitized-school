package ua.kpi.dreamteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.dreamteam.entities.Pupil;

/**
 * Created by Макс on 03.11.2016.
 */
public interface PupilRepository extends JpaRepository<Pupil, Long> {
}
