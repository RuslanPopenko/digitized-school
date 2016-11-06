package ua.kpi.dreamteam.services;

import org.springframework.stereotype.Service;
import ua.kpi.dreamteam.entities.SchoolClass;
import ua.kpi.dreamteam.repositories.SchoolClassRepository;
import ua.kpi.dreamteam.services.superclasses.AbstractService;

/**
 * Created by yevhenii on 03.11.16.
 */
@Service
public class SchoolClassServiceRepoImpl extends AbstractService<SchoolClass, Long, SchoolClassRepository> implements SchoolClassService {
}
