package ua.kpi.dreamteam.entities;

import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.Set;
import java.util.jar.Attributes;


/**
 * Created by yevhenii on 03.11.16.
 */
@Entity
public class Subject extends AbstractIdEntity<Long> implements Serializable{
    @Column
    private String name;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subjects")
    private Set<Pupil> pupil;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subjects")
    private Set<Teacher> teachers;

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

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", pupil=" + pupil +
                ", teachers=" + teachers +
                '}';
    }
}
