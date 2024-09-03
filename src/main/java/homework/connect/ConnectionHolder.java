package homework.connect;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionHolder {
    Connection getConnection() throws SQLException;

    void openTransaction() throws SQLException;

    void commitTransaction() throws SQLException;

    void rollbackTransaction() throws SQLException;

    void closeConnection() throws SQLException;
    void releaseConnection(Connection connection);
    boolean isTransactionOpen();

}
