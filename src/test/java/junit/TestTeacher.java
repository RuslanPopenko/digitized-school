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
 * Created by Vladislav on 07.11.16.
 */
public class TestTeacher {
    private static Teacher Svetlana, Zhenya;
    private static Person Tonya, Louie;
    private static School NewSchool, OldSchool,BestSchool;
    private static Subject Chemistry, PhysicalCulture;
    private static SchoolClass Room1408, Room228;

    @Before
    public static void prepareObjects(){

        Tonya = new Person();
        Tonya.setFirstName("Tonya");
        Tonya.setLastName("Williams");
        Tonya.setAge(18);
        Tonya.setSex(false);
        Louie = new Person();
        Louie.setFirstName("Louie");
        Louie.setLastName("Williams");
        Louie.setAge(17);
        Louie.setSex(true);

        NewSchool = new School();
        NewSchool.setName("288");
        NewSchool.setType("gymnasium");

        OldSchool = new School();
        OldSchool.setName("287");
        OldSchool.setType("lyceum");

        BestSchool = new School();
        BestSchool.setName("289");
        BestSchool.setType("college");

        Set<School> schools1 = new HashSet<School>();
        schools1.add(NewSchool);
        schools1.add(OldSchool);

        Set<School> schools2 = new HashSet<School>();
        schools2.add(BestSchool);
        schools2.add(OldSchool);

        Chemistry = new Subject();
        Chemistry.setName("Chemistry");
        PhysicalCulture = new Subject();
        PhysicalCulture.setName("PhysicalCulture");

        Set<Subject> subjects = new HashSet<Subject>();
        subjects.add(Chemistry);
        subjects.add(PhysicalCulture);

        Room1408 = new SchoolClass();
        Room1408.setName("Class1408");
        Room1408.setSchool(NewSchool);

        Room228 = new SchoolClass();
        Room228.setName("Class288");
        Room228.setSchool(NewSchool);

        Set<SchoolClass> classes = new HashSet<SchoolClass>();
        classes.add(Room1408);
        classes.add(Room228);


        //----------------------------------

        Svetlana = mock(Teacher.class);
        when(Svetlana.getPerson()).thenReturn(Tonya);
        when(Svetlana.getSchools()).thenReturn(schools1);
        when(Svetlana.getSchoolClasses()).thenReturn(classes);
        when(Svetlana.getSubjects()).thenReturn(subjects);


        Zhenya = mock(Teacher.class);
        when(Zhenya.getPerson()).thenReturn(Louie);
        when(Zhenya.getSchools()).thenReturn(schools2);
        when(Zhenya.getSchoolClasses()).thenReturn(classes);
        when(Zhenya.getSubjects()).thenReturn(subjects);


    }

    @Test
    public void testPerson(){
        assertNotEquals(Svetlana.getPerson(), Zhenya.getPerson());
    }

    @Test
    public void testSchools(){
        assertNotEquals(Svetlana.getSchools(), Zhenya.getSchools());
    }

    @Test
    public void testSchoolClasses(){
        assertEquals(Svetlana.getSchoolClasses(), Zhenya.getSchoolClasses());
    }

    @Test
    public void testSubjects(){
        assertEquals(Svetlana.getSubjects(), Zhenya.getSubjects());
    }

}
