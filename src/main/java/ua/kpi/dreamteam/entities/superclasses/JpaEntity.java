package ua.kpi.dreamteam.entities.superclasses;

import java.io.Serializable;

/**
 * Created by ruslan on 23.10.16.
 */
public interface JpaEntity<ID extends Serializable> extends Serializable {

    ID getId();

    void setId(ID id);

}
