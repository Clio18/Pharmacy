import dao.UserDAO;
import exception.UserNotFoundException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import model.User;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserDAOTest {
    private UserDAO userDAO;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Initial setup...");
        System.out.println("Code executes only once");

    }


    @Before
    public void setUp() {
        System.out.println("Code executes before each test method");
        userDAO = new UserDAO();
    }


    @Test
    public void whenReturnAll() {
        userDAO.save(new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build());
        userDAO.save(new User.Builder()
                .withLogin("Ab")
                .withPassword("AAb")
                .withName("AAAb")
                .withFamilyName("AAAAAb")
                .withEmail("@mailb")
                .withAddress("streetb")
                .withPhoneNumber("044b")
                .build());
        userDAO.save(new User.Builder()
                .withLogin("Ac")
                .withPassword("AAc")
                .withName("AAAc")
                .withFamilyName("AAAAAc")
                .withEmail("@mailc")
                .withAddress("streetc")
                .withPhoneNumber("044c")
                .build());
        assertEquals(userDAO.getAll().size(), 3);

    }

    @Test
    public void whenFindUserById() {
        User saved = userDAO.save(new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build());
        assertEquals(userDAO.findById(saved.getId()).getName(), saved.getName());
        assertEquals(userDAO.findById(-1), null);
    }

    @Test
    public void whenAddNewUser() throws Exception {
        userDAO.save(new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build());
        assertEquals(userDAO.getAll().size(), 1);
        userDAO.save(new User.Builder()
                .withLogin("Ab")
                .withPassword("AAb")
                .withName("AAAb")
                .withFamilyName("AAAAAb")
                .withEmail("@mailb")
                .withAddress("streetb")
                .withPhoneNumber("044b")
                .build());
        assertThat(userDAO.getAll().size(), is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddNewDrugException() {
        User user = null;
        userDAO.save(user);
    }


    @Test
    public void whenDeleteUserById() {
        User saved = userDAO.save(new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build());
        boolean result = userDAO.delete(saved.getId());
        assertThat(userDAO.getAll().size(), is(0));
        assertEquals(result, true);

        boolean anotherResult = userDAO.delete(saved.getId());
        assertEquals(anotherResult, false);
    }

    @Test
    public void whenUpdateUser() {
        User saved = userDAO.save(new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build());
        User drugForUpdate = userDAO.findByName(saved.getName());
        drugForUpdate.setName("Ola");
        userDAO.update(drugForUpdate);
        assertEquals(userDAO.findById(saved.getId()).getName(), drugForUpdate.getName());
    }

    @Test (expected = UserNotFoundException.class)
    public void whenUpdateDrugException() {
        User updatedUser = new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build();
        userDAO.update(updatedUser);
    }

    @Test
    public void whenFindUserByName() {
        User saved = userDAO.save(new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build());
        assertEquals(userDAO.findByName(saved.getName()).getEmail(), saved.getEmail());
    }

    @Test
    public void whenFindUserByLoginAndPassword() {
        User saved = userDAO.save(new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build());
        String login = saved.getLogin();
        String password = saved.getPassword();

        assertEquals(userDAO.findUserByLoginAndPassword(login, password).getEmail(), saved.getEmail());
    }


}
