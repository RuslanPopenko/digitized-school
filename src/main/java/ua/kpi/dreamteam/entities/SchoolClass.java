package ua.kpi.dreamteam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by yevhenii on 03.11.16.
 */
@Entity
public class SchoolClass extends AbstractIdEntity<Long> implements Serializable {
    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schoolClass")
    private Set<Pupil> pupils;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="school_id")
    @JsonIgnoreProperties(value = "schoolClasses")
    private School school;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "schoolClass_subject_cross",
            joinColumns = @JoinColumn(name = "schoolClass_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(Set<Pupil> pupils) {
        this.pupils = pupils;
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
                ", pupils=" + pupils +
                ", school=" + school +
                ", subjects=" + subjects +
                '}';
    }
}
