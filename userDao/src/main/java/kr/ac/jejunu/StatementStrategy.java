package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jhkang on 4/8/16.
 */
public interface StatementStrategy {
    PreparedStatement makeStatement(Connection connection) throws SQLException;
}
