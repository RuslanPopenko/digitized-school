package ua.kpi.dreamteam.entities.superclasses;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ruslan on 23.10.16.
 */
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class AbstractIdEntity<ID extends Serializable> implements JpaEntity<ID>, Serializable {

    @Id
    @GeneratedValue
    @Column
    protected ID id;

    public AbstractIdEntity() {
    }

    public AbstractIdEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
