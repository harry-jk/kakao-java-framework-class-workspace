package kr.ac.jejunu;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by jhkang on 3/25/16.
 */
public class UserDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new DaoFactory().getUserDao();

        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "헐크";
        String password = "2222";

        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new DaoFactory().getUserDao();
        Long id = userDao.add(user);

        User resultUesr = userDao.get(id);

        assertThat(resultUesr.getId(), is(id));
        assertThat(resultUesr.getName(), is(name));
        assertThat(resultUesr.getPassword(), is(password));
    }
}
