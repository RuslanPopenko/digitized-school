package ua.kpi.dreamteam.services;

import org.springframework.stereotype.Service;
import ua.kpi.dreamteam.entities.Teacher;
import ua.kpi.dreamteam.repositories.TeacherRepository;
import ua.kpi.dreamteam.services.superclasses.AbstractService;

/**
 * Created by Макс on 03.11.2016.
 */
public class TeacherServiceRepoImpl extends AbstractService<Teacher, Long, TeacherRepository> implements TeacherService {
}
