package kr.ac.jejunu;

/**
 * Created by jhkang on 4/1/16.
 */
public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(new SimpleConnectionMaker());
    }
}
