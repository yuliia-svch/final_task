package app.dao;

import app.entities.Application;
import app.entities.DBCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationDao {
    public void addApplication(Application app) throws SQLException {
        String INSERT_APPLICATION_SQL = "INSERT INTO application" +
                "  (address, baggage_type, weight, volume, date_rec, user_id) VALUES " +
                " (?, ?, ?, ?, ?, ?);";
        Connection con = DBCPDataSource.getConnection();

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_APPLICATION_SQL)) {
            preparedStatement.setString(1, app.getAddress());
            preparedStatement.setString(2, app.getBaggageType());
            preparedStatement.setDouble(3, app.getWeight());
            preparedStatement.setDouble(4, app.getVolume());
            preparedStatement.setString(5, app.getDateOfReceival());
            preparedStatement.setInt(6, app.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            UserDao.printSQLException(e);
        }
    }
}
