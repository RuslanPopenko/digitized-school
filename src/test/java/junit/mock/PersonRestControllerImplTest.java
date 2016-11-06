package junit.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.kpi.dreamteam.entities.Person;
import ua.kpi.dreamteam.restcontrollers.PersonRestControllerImpl;
import ua.kpi.dreamteam.services.PersonService;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by ruslan on 06.11.16.
 */
public class PersonRestControllerImplTest {

    private MockMvc mvc;

    @Mock
    private PersonService personServiceMock;

    @InjectMocks
    private PersonRestControllerImpl personRestController;

    private Person person;

    @Before
    public void beforeTestGetPerson() throws Exception {
        MockitoAnnotations.initMocks(this);
        person = new Person();
        person.setId(1l);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(50);
        person.setSex(true);
    }

    @Test
    public void testGetPerson() throws Exception {

        given(personServiceMock.find(person.getId()))
                .willReturn(person);

        mvc.perform(get("/api/persons/{id}", person.getId()).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

}
