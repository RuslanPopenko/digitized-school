package ua.kpi.dreamteam.services;

import org.springframework.stereotype.Service;
import ua.kpi.dreamteam.entities.Person;
import ua.kpi.dreamteam.repositories.PersonRepository;
import ua.kpi.dreamteam.services.superclasses.AbstractService;

/**
 * Created by ruslan on 29.10.16.
 */
@Service
public class PersonServiceRepoImpl extends AbstractService<Person, Long, PersonRepository> implements PersonService {
}
