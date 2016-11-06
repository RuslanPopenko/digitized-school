package ua.kpi.dreamteam.services;

import org.springframework.stereotype.Service;
import ua.kpi.dreamteam.entities.School;
import ua.kpi.dreamteam.repositories.SchoolRepository;
import ua.kpi.dreamteam.services.superclasses.AbstractService;

/**
 * Created by yevhenii on 03.11.16.
 */
@Service
public class SchoolServiceRepoImpl extends AbstractService<School, Long, SchoolRepository> implements SchoolService {
}
