package orm;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    private final static String SQL_INSERT
            = "INSERT INTO phonebook(idphonebook, lastname, phone ) " +
              "VALUES(?,?,?)";
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");

        PreparedStatement ps = getConnection().prepareStatement(SQL_INSERT);
        ps.setString(1, "'); DROP TABLE phonebook;");
//        DriverManager.getConnection();

        return DriverManager.getConnection(url, user, pass);
    }
}
