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
        UserDao userDao = new UserDao();

        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
}
