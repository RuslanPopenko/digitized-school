package junit.integration;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import ua.kpi.dreamteam.entities.Person;

import static org.junit.Assert.*;

public class PersonIntegrationTest {

    private static final String GET_PERSON_URL = "http://localhost:8080/api/persons/{id}";

    @Test
    public void get_person_by_id_integration_test() {
        RestTemplate restTemplate = new RestTemplate();
        Person person = null;
        try {
            person = restTemplate.getForObject(GET_PERSON_URL, Person.class, 1L);
        } catch (Exception e) {
            fail("Exception must not be thrown");
        }
        assertNotNull(person);
        assertEquals(person.getAge().longValue(), 10L);
        assertEquals(person.getFirstName(), "max");
        assertEquals(person.getLastName(), "morozov");
        assertEquals(person.getSex(), true);
    }

}
