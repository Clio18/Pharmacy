import dao.UserDAO;
import exception.UserNotFoundException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import userInterface.User;
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
        userDAO.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        userDAO.save(new User("Ab", "AAb", "AAAb", "AAAAb", "@mailb", "street b", "0440"));
        userDAO.save(new User("Ac", "AAc", "AAAc", "AAAAc", "@mailc", "street c", "04409"));
        assertEquals(userDAO.getAll().size(), 3);
    }

    @Test
    public void whenFindUserById() {
        User saved = userDAO.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        assertEquals(userDAO.findById(saved.getId()).getName(), saved.getName());
        assertEquals(userDAO.findById(-1), null);
    }

    @Test
    public void whenAddNewUser() throws Exception {
        userDAO.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        assertEquals(userDAO.getAll().size(), 1);
        userDAO.save(new User("Ab", "AAb", "AAAb", "AAAAb", "@mailb", "street b", "0440"));
        assertThat(userDAO.getAll().size(), is(2));
    }

    @Test
    public void whenAddNewDrugException() {
        User user = null;
        try {
            userDAO.save(user);
        } catch (Exception e) {
            assertEquals(e.getClass(), new IllegalArgumentException().getClass());
        }
    }


    @Test
    public void whenDeleteUserById() {
        User saved = userDAO.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        boolean result = userDAO.delete(saved.getId());
        assertThat(userDAO.getAll().size(), is(0));
        assertEquals(result, true);

        boolean anotherResult = userDAO.delete(saved.getId());
        assertEquals(anotherResult, false);
    }

    @Test
    public void whenUpdateUser() {
        User saved = userDAO.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        User drugForUpdate = userDAO.findByName(saved.getName());
        drugForUpdate.setName("Ola");
        userDAO.update(drugForUpdate);
        assertEquals(userDAO.findById(saved.getId()).getName(), drugForUpdate.getName());
    }

    @Test
    public void whenUpdateDrugException() {
        User updatedUser = new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044");
        try {
            userDAO.update(updatedUser);
        } catch (Exception e) {
            assertEquals(e.getMessage(), new UserNotFoundException().getMessage());
        }
    }

    @Test
    public void whenFindUserByName() {
        User saved = userDAO.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        assertEquals(userDAO.findByName(saved.getName()).getEmail(), saved.getEmail());
    }

    @Test
    public void whenFindUserByLoginAndPassword() {
        User saved = userDAO.save(new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044"));
        String login = saved.getLogin();
        String password = saved.getPassword();

        assertEquals(userDAO.findUserByLoginAndPassword(login, password).getEmail(), saved.getEmail());
    }


}
