import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
public class stopDao {
    DatabaseConnect conn = new DatabaseConnect();
    Connection connection = conn.getConnection();

    public int add(Stop stop)throws SQLException{
        String query
            = "insert into stop(stopNumber, "
            + "stopAddress) VALUES (?,?)";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setInt(1, stop.getStopNumber());
        ps.setString(2, stop.getStopAddress());
        int n = ps.executeUpdate();
        return n;
    }
}
