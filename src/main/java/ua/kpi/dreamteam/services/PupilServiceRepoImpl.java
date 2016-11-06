package ua.kpi.dreamteam.services;

import org.springframework.stereotype.Service;
import ua.kpi.dreamteam.entities.Pupil;
import ua.kpi.dreamteam.repositories.PupilRepository;
import ua.kpi.dreamteam.services.superclasses.AbstractService;

/**
 * Created by Макс on 03.11.2016.
 */
@Service
public class PupilServiceRepoImpl extends AbstractService<Pupil, Long, PupilRepository> implements PupilService {
}
