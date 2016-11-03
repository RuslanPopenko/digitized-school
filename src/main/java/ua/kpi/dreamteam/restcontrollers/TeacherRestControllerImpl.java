package ua.kpi.dreamteam.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dreamteam.entities.Teacher;
import ua.kpi.dreamteam.restcontrollers.superclasses.AbstractRestController;
import ua.kpi.dreamteam.services.TeacherService;

/**
 * Created by Макс on 03.11.2016.
 */
public class TeacherRestControllerImpl extends AbstractRestController<Teacher, Long, TeacherService> {
}
