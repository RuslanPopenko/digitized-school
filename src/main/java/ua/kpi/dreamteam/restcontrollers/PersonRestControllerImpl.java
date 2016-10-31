package ua.kpi.dreamteam.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dreamteam.entities.Person;
import ua.kpi.dreamteam.restcontrollers.superclasses.AbstractRestController;
import ua.kpi.dreamteam.services.PersonService;

/**
 * Created by ruslan on 27.10.16.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonRestControllerImpl extends AbstractRestController<Person, Long, PersonService> {
}
