import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
public class TripDao {
    DatabaseConnect conn = new DatabaseConnect();
    Connection connection = conn.getConnection();

    public int add(Trip trip)throws SQLException{
        String query
            = "insert into trip(tripNumber) VALUES (?)";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setInt(1, trip.getTripNumber());
        int n = ps.executeUpdate();
        return n;
    }
}
