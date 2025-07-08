package university.student.service;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import university.student.model.Role;
import university.student.model.Student;
import university.student.model.User;
import university.student.model.UserRepository;

public class PortalServiceTestBase {

    @MockBean
    protected UserRepository userRepository;
    @Autowired
    protected PortalService portalService;

    protected User userStudent;
    protected User userNotStudent;
    protected Student student;


    @BeforeEach
    public void setUp() {
        createTestObjects();
        defineMockingBehaviour();
    }

    protected void createTestObjects() {

        Faker faker = new Faker();
        userStudent = new User(faker.name().username(), Role.STUDENT, "user@gmail.com", faker.animal().name());
        userStudent.setId(1L);
        student = new Student(faker.name().firstName(), faker.name().lastName());
        userStudent.setStudent(student);
        userNotStudent = new User(faker.name().username(), Role.STUDENT, "uns@gmail.com", faker.animal().name());
        userNotStudent.setId(2L);
    }

    protected void defineMockingBehaviour() {
        Mockito.when(userRepository.findUserByUserName(userStudent.getUserName()))
                .thenReturn(userStudent);
        Mockito.when(userRepository.findUserByUserName(userNotStudent.getUserName()))
                .thenReturn(userNotStudent);
    }

    @AfterEach
    public void tearDown() {
        userStudent = null;
        userNotStudent = null;
        student = null;
        userRepository = null;
        portalService = null;
    }
}
