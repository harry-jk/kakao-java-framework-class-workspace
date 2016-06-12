package kr.ac.jejunu.hibernate;

import kr.ac.jejunu.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jhkang on 2016-06-12.
 */
public class BasicHibernateTest {
    private Logger logger = LoggerFactory.getLogger(BasicHibernateTest.class);

    SessionFactory sessionFactory;

    @Before
    public void setup() {
        Configuration configuration = new Configuration().configure("jejunu.cfg.xml");
        configuration.addResource("User.hbm.xml");
        configuration.addResource("Comment.hbm.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(configuration.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        sessionFactory = configuration.buildSessionFactory(standardServiceRegistry);
    }

    @After
    public void finish() {
        sessionFactory.close();
    }

    @Test
    public void getUserTest() {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, 1);
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));
        user.getComments().forEach(comment -> {
            logger.error(comment.getContent());
        });
        session.close();
    }

    @Test
    public void saveUserTest() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setName("testuser");
        user.setPassword("1234");
        session.save(user);

        logger.info("**************  get after save(start) ******************");
        User saveUser = session.get(User.class, user.getId());
        logger.info("**************  get after save(end) ******************");
        assertThat(saveUser.getName(), is(user.getName()));
        assertThat(saveUser.getPassword(), is(user.getPassword()));

        session.getTransaction().commit();
        session.close();
    }
}
