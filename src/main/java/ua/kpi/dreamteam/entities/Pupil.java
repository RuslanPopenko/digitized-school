package ua.kpi.dreamteam.entities;

import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Макс on 03.11.2016.
 */
@Entity
public class Pupil extends AbstractIdEntity<Long> implements Serializable {
    @Column
    private Person person;

    @Column
    private School school;

    @Column
    private SchoolClass schoolClass;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pupils")
    private Set<Subject> subjects;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
