package app.dao;

import app.entities.DBCPDataSource;
import app.entities.User;

import javax.naming.NamingException;
import java.sql.*;

public class UserDao {
    public int registerUser(User user) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO auth_user" +
                "  (login, password, role) VALUES " +
                " (?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DBCPDataSource.getConnection();

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole().name());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);
        }
        return result;
    }

    public char isInDatabase(User user) throws ClassNotFoundException, NamingException, SQLException {

        String FIND_USER_SQL = "SELECT * FROM auth_user WHERE login = ? AND role = 1";
        String FIND_MANAGER_SQL = "SELECT * FROM auth_user WHERE login = ? AND role = 2";
        ResultSet rs = null;

        Connection con = DBCPDataSource.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement(FIND_USER_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if(user.getPassword().equals(rs.getString("password"))) {
                    return 'u';
                } else {
                    return 'p';
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            close(rs);
        }
        try (PreparedStatement preparedStatement = con.prepareStatement(FIND_MANAGER_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if(user.getPassword().equals(rs.getString("password"))) {
                    return 'm';
                } else {
                    return 'p';
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            close(rs);
        }
        return 'n';
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    private void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception ex) {
                throw new IllegalStateException("Cannot close " + ac);
            }
        }
    }
}
