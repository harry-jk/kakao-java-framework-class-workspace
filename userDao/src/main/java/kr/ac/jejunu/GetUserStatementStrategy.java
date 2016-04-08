package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jhkang on 4/8/16.
 */
public class GetUserStatementStrategy implements StatementStrategy {
    private Long id;

    public GetUserStatementStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        String sql = "select * from userinfo where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
