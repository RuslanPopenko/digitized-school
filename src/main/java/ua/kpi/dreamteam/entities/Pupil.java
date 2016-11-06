package ua.kpi.dreamteam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Макс on 03.11.2016.
 */
@Entity
public class Pupil extends AbstractIdEntity<Long> implements Serializable {
    @Column
    private Person person;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="school_id")
    @JsonIgnoreProperties(value = "pupils")
    private School school;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="schoolClass_id")
    @JsonIgnoreProperties(value = "pupils")
    private SchoolClass schoolClass;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "pupil_subject_cross",
            joinColumns = @JoinColumn(name = "pupil_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
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

    @Override
    public String toString() {
        return "Pupil{" +
                "person=" + person +
                ", school=" + school +
                ", schoolClass=" + schoolClass +
                ", subjects=" + subjects +
                '}';
    }
}
