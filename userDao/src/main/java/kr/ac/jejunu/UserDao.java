package kr.ac.jejunu;


import java.sql.*;

/**
 * Created by jhkang on 3/25/16.
 */
public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://db.skyserv.kr/jejunu", "jeju", "jejupw");

        String sql = "select * from userinfo where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        return user;
    }
}
