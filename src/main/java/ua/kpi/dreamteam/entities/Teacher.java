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
public class Teacher extends AbstractIdEntity<Long> implements Serializable {
    @Column
    private Person person;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teachers")
    private Set<School> schools;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teachers")
    private Set<SchoolClass> schoolClasses;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teachers")
    private Set<Subject> subjects;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }

    public Set<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "person=" + person +
                ", schools=" + schools +
                ", schoolClasses=" + schoolClasses +
                ", subjects=" + subjects +
                '}';
    }
}
