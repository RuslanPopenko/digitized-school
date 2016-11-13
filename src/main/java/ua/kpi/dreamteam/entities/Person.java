package ua.kpi.dreamteam.entities;

import ua.kpi.dreamteam.entities.superclasses.AbstractIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by ruslan on 29.10.16.
 */
@Entity
public class Person extends AbstractIdEntity<Long> implements Serializable {
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Column
    private Boolean sex;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    
    public boolean isBoy() {
        if (this.getSex() == null)
            throw new IllegalStateException();
    	if (this.getSex() && this.getAge() < 12)
    		return true;
    	return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        return sex != null ? sex.equals(person.sex) : person.sex == null;

    }
}
