package app.dao;

import app.entities.DBCPDataSource;
import app.entities.Receipt;

import java.sql.*;

public class ReceiptDao {
    public void addReceipt(Receipt rec) throws SQLException {
        String INSERT_APPLICATION_SQL = "INSERT INTO receipt" +
                "  (price, application_id) VALUES " +
                " (?, ?);";
        Connection con = DBCPDataSource.getConnection();
        ResultSet rs;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_APPLICATION_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, rec.getPrice());
            preparedStatement.setInt(2, rec.getAppId());

            if(preparedStatement.executeUpdate()>0) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    rec.setRecId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            UserDao.printSQLException(e);
        }
    }
}
