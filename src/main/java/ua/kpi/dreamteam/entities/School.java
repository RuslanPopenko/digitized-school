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
public class School extends AbstractIdEntity<Long> implements Serializable {
    @Column
    private String name;

    @Column
    private String type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "school")
    private Set<Pupil> pupils;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "school")
    private Set<SchoolClass> schoolClasses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(Set<Pupil> pupils) {
        this.pupils = pupils;
    }

    public Set<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

}
