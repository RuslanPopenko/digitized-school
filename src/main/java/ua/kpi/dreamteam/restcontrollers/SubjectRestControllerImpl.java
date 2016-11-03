package ua.kpi.dreamteam.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dreamteam.entities.Subject;
import ua.kpi.dreamteam.restcontrollers.superclasses.AbstractRestController;
import ua.kpi.dreamteam.services.SubjectService;

/**
 * Created by yevhenii on 03.11.16.
 */
@RestController
@RequestMapping("/api/subjects")
public class SubjectRestControllerImpl extends AbstractRestController<Subject, Long, SubjectService> {
}
