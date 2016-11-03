package ua.kpi.dreamteam.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dreamteam.entities.School;
import ua.kpi.dreamteam.restcontrollers.superclasses.AbstractRestController;
import ua.kpi.dreamteam.services.SchoolService;

/**
 * Created by yevhenii on 03.11.16.
 */
@RestController
@RequestMapping("/api/schools")
public class SchoolRestControllerImpl extends AbstractRestController<School, Long, SchoolService> {
}
