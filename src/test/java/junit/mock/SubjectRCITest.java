package junit.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.kpi.dreamteam.entities.Subject;
import ua.kpi.dreamteam.restcontrollers.SubjectRestControllerImpl;
import ua.kpi.dreamteam.services.SubjectService;
import ua.kpi.dreamteam.utils.StaticUtls;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Макс on 07.11.2016.
 */
public class SubjectRCITest {
    private MockMvc mvc;

    @Mock
    private SubjectService subjectServiceMock;

    @InjectMocks
    private SubjectRestControllerImpl subjectRestController;
    private Subject subject;

    @Before
    public void prepareSubject() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(subjectRestController).build();
        subject = new Subject();
        subject.setId(0l);
        subject.setName("Math");
    }

    @Test
    public void getSubjectTest() throws Exception {
        given(subjectServiceMock.find(subject.getId())).willReturn(subject);
        mvc.perform(get("/api/subjects/{id}", subject.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(StaticUtls.objToJsonString(subject)));
    }
}
