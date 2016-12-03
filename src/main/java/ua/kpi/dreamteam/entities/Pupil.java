package ua.kpi.dreamteam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Макс on 03.11.2016.
 */
@Entity
public class Pupil extends AbstractIdEntity<Long> implements Serializable {
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="person_id")
    private Person person;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="school_id")
    @JsonIgnoreProperties({"pupils", "schoolClasses", "pupil"})
    private School school;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="schoolClass_id")
    @JsonIgnoreProperties({"pupils", "school"})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pupil pupil = (Pupil) o;

        if (person != null ? !person.equals(pupil.person) : pupil.person != null) return false;
        if (school != null ? !school.equals(pupil.school) : pupil.school != null) return false;
        if (schoolClass != null ? !schoolClass.equals(pupil.schoolClass) : pupil.schoolClass != null) return false;
        return subjects != null ? subjects.equals(pupil.subjects) : pupil.subjects == null;

    }

}
