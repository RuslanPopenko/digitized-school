package ua.kpi.dreamteam.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dreamteam.entities.SchoolClass;
import ua.kpi.dreamteam.restcontrollers.superclasses.AbstractRestController;
import ua.kpi.dreamteam.services.SchoolClassService;

/**
 * Created by yevhenii on 03.11.16.
 */
@RestController
@RequestMapping("/api/schoolclasses")
public class SchoolClassRestControllerImpl extends AbstractRestController<SchoolClass, Long, SchoolClassService> {
}
