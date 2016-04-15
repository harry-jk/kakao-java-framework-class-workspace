package kr.ac.jejunu;


import java.sql.*;

/**
 * Created by jhkang on 3/25/16.
 */
public class UserDao {
    private JdbcContext jdbcContext;

    public User get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = (Connection connection) -> {
            String sql = "select * from userinfo where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = (Connection connection) -> {
            String sql = "insert into userinfo (name, password) values (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement;
        };
        return jdbcContext.jdbcContextWithStatementStrategyForInsert(statementStrategy);
    }

    public void delete(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = (Connection connection) -> {
            String sql = "delete from userinfo where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void update(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = (Connection connection) -> {
            String sql = "update userinfo set name = ?, password = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getId());

            return preparedStatement;
        };
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
