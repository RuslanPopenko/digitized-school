package ua.kpi.dreamteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.dreamteam.entities.Person;

/**
 * Created by ruslan on 29.10.16.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
