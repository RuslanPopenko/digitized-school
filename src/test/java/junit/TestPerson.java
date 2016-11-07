package junit;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.kpi.dreamteam.entities.Person;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Макс on 07.11.2016.
 */
public class TestPerson {
    private static Person someone, women, boy;
    private static Person guy, friend, brother;

    @BeforeClass
    public static void prepareObjects() {
        someone = new Person();
        someone.setAge(45);

        women = new Person();
        women.setSex(false);
        women.setAge(30);

        boy = new Person();
        boy.setSex(true);
        boy.setAge(10);

        //------------------------------------------------

        guy = mock(Person.class);
        when(guy.getFirstName()).thenReturn("Mike");
        when(guy.getLastName()).thenReturn("White");
        when(guy.isBoy()).thenReturn(true);

        friend = mock(Person.class);
        when(friend.getFirstName()).thenReturn("Mike");

        brother = mock(Person.class);
        when(brother.getLastName()).thenReturn("White");
    }

    @Test(expected = IllegalStateException.class)
    public void testUndefinedPerson() {
        someone.isBoy();
    }

    @Test
    public  void testAdultFemalePerson() {
        assertFalse(women.isBoy());
    }

    @Test
    public  void testSmallMalePerson() {
        assertTrue(boy.isBoy());
    }

    @Test
    public void testSameName() {
        assertEquals(guy.getFirstName(), friend.getFirstName());
    }

    @Test
    public void testSameSurname() {
        assertEquals(guy.getLastName(), brother.getLastName());
    }

    @Test
    public  void testMockPerson() {
        assertEquals(guy.isBoy(), true);
    }
}
