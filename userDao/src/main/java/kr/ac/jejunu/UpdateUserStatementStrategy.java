package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jhkang on 4/8/16.
 */
public class UpdateUserStatementStrategy implements StatementStrategy {
    private User user;

    public UpdateUserStatementStrategy(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        String sql = "update userinfo set name = ?, password = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setLong(3, user.getId());

        return preparedStatement;
    }
}
