package ua.kpi.dreamteam.entities;

import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by yevhenii on 03.11.16.
 */
@Entity
public class SchoolClass extends AbstractIdEntity<Long> implements Serializable {
    @Column
    private String name;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schoolclasses")
    private Set<Pupil> pupil;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schoolclasses")
    private Set<Teacher> teachers;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schoolclasses")
    private School school;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schoolclasses")
    private Set<Subject> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pupil> getPupil() {
        return pupil;
    }

    public void setPupil(Set<Pupil> pupil) {
        this.pupil = pupil;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "name='" + name + '\'' +
                ", pupil=" + pupil +
                ", teachers=" + teachers +
                ", school=" + school +
                ", subjects=" + subjects +
                '}';
    }
}
