package homework.connect.implement;

import homework.connect.ConnectionHolder;
import homework.exeption.ConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectionHolderImpl implements ConnectionHolder {
    private final DataSource dataSource;
    private final ThreadLocal<Connection> threadLocalConnection = new ThreadLocal<>();
    private final List<Connection> connectionPool = new ArrayList<>();

    @Autowired
    public ConnectionHolderImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = threadLocalConnection.get();
        if (connection == null || connection.isClosed()) {
            connection = getConnectionFromPool();
            threadLocalConnection.set(connection);
        }

        return connection;
    }

    @Override
    public void openTransaction() throws SQLException {
        Connection connection = getConnection();
        if (!connection.getAutoCommit()) {
            throw new ConnectionException();
        }

        connection.setAutoCommit(false);
    }

    @Override
    public void commitTransaction() throws SQLException {
        Connection connection = getConnection();
        if (connection.getAutoCommit()) {
            throw new IllegalStateException("No transaction opened for this thread");
        }
        try {
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            releaseConnection(connection);

        }
    }



    @Override
    public void rollbackTransaction() throws SQLException {
        Connection connection = getConnection();
        if (connection.getAutoCommit()) {
            throw new IllegalStateException("No transaction opened for this thread");
        }
        connection.rollback();
        connection.setAutoCommit(true);
    }

    @PreDestroy
    @Override
    public void closeConnection() throws SQLException {
        Connection connection = threadLocalConnection.get();
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        threadLocalConnection.remove();
    }

    private synchronized Connection getConnectionFromPool() throws SQLException {
        if (connectionPool.isEmpty()) {

            return dataSource.getConnection();
        } else {

            return connectionPool.remove(connectionPool.size() - 1);
        }
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection != null && isTransactionOpen()) {

            return;
        }
        if (connection != null) {
            connectionPool.add(connection);
        }
    }
    public boolean isTransactionOpen() {
        try {
            Connection connection = threadLocalConnection.get();

            return connection != null && !connection.getAutoCommit();
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }
}
