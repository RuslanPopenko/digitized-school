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

    public Set<Pupil> getPupil() {
        return pupils;
    }

    public void setPupil(Set<Pupil> pupils) {
        this.pupils = pupils;
    }

    public Set<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", pupils=" + pupils +
                ", schoolClasses=" + schoolClasses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (name != null ? !name.equals(school.name) : school.name != null) return false;
        if (type != null ? !type.equals(school.type) : school.type != null) return false;
        if (pupils != null ? !pupils.equals(school.pupils) : school.pupils != null) return false;
        return schoolClasses != null ? schoolClasses.equals(school.schoolClasses) : school.schoolClasses == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (pupils != null ? pupils.hashCode() : 0);
        result = 31 * result + (schoolClasses != null ? schoolClasses.hashCode() : 0);
        return result;
    }
}
