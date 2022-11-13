import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class DriverDao {
    DatabaseConnect conn = new DatabaseConnect();
    Connection connection = conn.getConnection();

    //Add a driver to database
    public int add(Driver driver) throws SQLException {
        String query
            = "insert into driver(driverNum) VALUES (?)";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setInt(1, driver.getDriver_id());
        int n = ps.executeUpdate();
        return n;
    }


}
