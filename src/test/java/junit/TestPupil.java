package junit;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dreamteam.entities.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by yevhenii on 07.11.16.
 */
public class TestPupil {
    private static Pupil Lera, Jack;
    private static Person Rom,Ram;
    private static School First;
    private static Subject Math, Bio;
    private static SchoolClass Room21;

    @Before
    public static void prepareObjects(){

        Rom = new Person();
        Rom.setFirstName("Rom");
        Rom.setLastName("Adams");
        Rom.setAge(11);
        Rom.setSex(true);
        Ram = new Person();
        Ram.setFirstName("Ram");
        Ram.setLastName("Adams");
        Ram.setAge(11);
        Ram.setSex(false);

        First = new School();
        First.setName("First");
        First.setType("lyceum");

        Math = new Subject();
        Math.setName("Math");
        Bio = new Subject();
        Bio.setName("Biology");

        Set<Subject> subjects = new HashSet<Subject>();
        subjects.add(Math);
        subjects.add(Bio);

        Room21 = new SchoolClass();
        Room21.setName("Class21");
        Room21.setSchool(First);


        //----------------------------------

        Lera = mock(Pupil.class);
        when(Lera.getPerson()).thenReturn(Rom);
        when(Lera.getSchool()).thenReturn(First);
        when(Lera.getSchoolClass()).thenReturn(Room21);
        when(Lera.getSubjects()).thenReturn(subjects);


        Jack = mock(Pupil.class);
        when(Jack.getPerson()).thenReturn(Ram);
        when(Jack.getSchool()).thenReturn(First);
        when(Jack.getSchoolClass()).thenReturn(Room21);
        when(Jack.getSubjects()).thenReturn(subjects);


    }

    @Test
    public void testPerson(){
        assertNotEquals(Lera.getPerson(),Jack.getPerson());
    }

    @Test
    public void testSchool(){
        assertEquals(Lera.getSchool(), Jack.getSchool());
    }

    @Test
    public void testSchoolClass(){
        assertEquals(Lera.getSchoolClass(), Jack.getSchoolClass());
    }

    @Test
    public void testSubjects(){
        assertEquals(Lera.getSubjects(), Jack.getSubjects());
    }

}
