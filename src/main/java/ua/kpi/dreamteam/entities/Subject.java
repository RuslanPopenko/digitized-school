package ua.kpi.dreamteam.entities;

import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.*;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
