package ua.kpi.dreamteam.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dreamteam.entities.Pupil;
import ua.kpi.dreamteam.restcontrollers.superclasses.AbstractRestController;
import ua.kpi.dreamteam.services.PupilService;

/**
 * Created by Макс on 03.11.16.
 */
@RestController
@RequestMapping("/api/pupils")
public class PupilRestControllerImpl extends AbstractRestController<Pupil, Long, PupilService> {
}
