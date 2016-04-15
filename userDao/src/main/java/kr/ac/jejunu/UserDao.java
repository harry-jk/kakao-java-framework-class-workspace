package kr.ac.jejunu;


import java.sql.*;

/**
 * Created by jhkang on 3/25/16.
 */
public class UserDao {
    private JdbcContext jdbcContext;

    public User get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddUserStatementStrategy(user);
        return jdbcContext.jdbcContextWithStatementStrategyForInsert(statementStrategy);
    }

    public void delete(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new DeleteUserStatementStrategy(id);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void update(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new UpdateUserStatementStrategy(user);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
