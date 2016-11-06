package ua.kpi.dreamteam.services;

import org.springframework.stereotype.Service;
import ua.kpi.dreamteam.entities.Subject;
import ua.kpi.dreamteam.repositories.SubjectRepository;
import ua.kpi.dreamteam.services.superclasses.AbstractService;

/**
 * Created by yevhenii on 03.11.16.
 */
@Service
public class SubjectServiceRepoImpl extends AbstractService<Subject, Long, SubjectRepository> implements SubjectService {
}
