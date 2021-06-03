package app.dao;

import app.entities.Application;
import app.entities.DBCPDataSource;
import app.entities.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDao {
    public void addApplication(Application app) throws SQLException {
        String INSERT_APPLICATION_SQL = "INSERT INTO application" +
                "  (address, baggage_type, weight, volume, date_rec, user_id) VALUES " +
                " (?, ?, ?, ?, ?, ?);";
        Connection con = DBCPDataSource.getConnection();
        ResultSet rs;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_APPLICATION_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, app.getAddress());
            preparedStatement.setString(2, app.getBaggageType());
            preparedStatement.setDouble(3, app.getWeight());
            preparedStatement.setDouble(4, app.getVolume());
            preparedStatement.setString(5, app.getDateOfReceival());
            preparedStatement.setInt(6, app.getUserId());
            if(preparedStatement.executeUpdate()>0) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    app.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            UserDao.printSQLException(e);
        }
    }

    public List<Application> getAllApplications(){
        List<Application> apps = new ArrayList<>();
        try (Connection con = DBCPDataSource.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from application")) {
            while (rs.next()) {
                Application app = new Application();
                app.setId(rs.getInt("id"));
                app.setAddress(rs.getString("address"));
                app.setBaggageType(rs.getString("baggage_type"));
                app.setWeight(rs.getDouble("weight"));
                app.setVolume(rs.getDouble("volume"));
                app.setDate(rs.getString("date_rec"));
                app.setUserId(rs.getInt("user_id"));
                apps.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apps;
    }

    public String getUserLoginById(int id) {
        ResultSet rs;
        try (Connection con = DBCPDataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement("select * " +
                     "from auth_user " +
                     "where id = ?")) {
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
