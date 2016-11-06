package junit;

import org.junit.Test;
import ua.kpi.dreamteam.entities.Person;
import ua.kpi.dreamteam.utils.StaticUtls;

import static org.junit.Assert.*;

/**
 * Created by ruslan on 06.11.16.
 */
public class StaticUtlsTest {

    @Test
    public void testDeleteSuffixOptional() {
        String suffix = "-suffix";
        String dummyStr = "dummy-string";

        String dummyStrWithSuffix = dummyStr + suffix;
        String result = StaticUtls.deleteSuffixOptional(dummyStrWithSuffix, suffix);
        assertEquals(result, dummyStr);

        result = StaticUtls.deleteSuffixOptional(dummyStr, suffix);
        assertEquals(result, dummyStr);

    }

    @Test
    public void testNullAwareBeanCopy() {
        String firstName = "Jonh";
        String lastName = "Doe";

        Person person1 = new Person();
        Person person2 = new Person();

        person1.setFirstName(firstName);
        person2.setLastName(lastName);

        try {
            StaticUtls.nullAwareBeanCopy(person2, person1);
        } catch (Exception e) {
            fail("Exception must not be thrown");
        }

        assertEquals(person2.getFirstName(), firstName);
        assertEquals(person2.getLastName(), lastName);
        assertNull(person2.getAge());
        assertNull(person2.getSex());

    }
}
