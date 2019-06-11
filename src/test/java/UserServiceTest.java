import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.mapstruct.factory.Mappers;
import webapp.dto.User;
import webapp.mapper.UserMapper;
import webapp.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class UserServiceTest {

    private UserService userService;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private User user;

    @Before
    public void setUp() throws Exception { user = new User()
            .setEmail("email")
            .setPassword("password")
            .setFirstName("FirstName")
            .setLastName("LastName");

        userService.createOne(user);
    }

    @Test
    public void createUser() {
        User testUser = new User()
                .setEmail("Test User")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createOne(testUser);

        assertEquals(testUser, userMapper.mapUserToUserEntity((User) userService.findOneById(5L)));
    }

    @Test
    public void getUserById() {
        assertEquals(user, userMapper.mapUserToUserEntity((User) userService.findOneById(1L)));
    }

    @Test
    public void deleteUserById() {
        userService.deleteOneById(1L);
        assertNull(userService.findOneById(1L));
    }

    @Test
    public void getAllUsers() {
        assertEquals(3, userService.findAll().size());
    }

    @Test
    public void getUserByEmail() {
        User SecondTestUser = new User()
                .setEmail("Second Test User")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createOne(SecondTestUser);
        assertEquals(SecondTestUser, userMapper.mapUserToUserEntity((User) userService.findOneByEmail("Second Test User")));
    }
}
