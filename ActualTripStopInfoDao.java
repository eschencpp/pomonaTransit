import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class ActualTripStopInfoDao {
    DatabaseConnect conn = new DatabaseConnect();
    Connection connection = conn.getConnection();

    public int add(ActualTripStopInfo a) throws SQLException{
        String query
            = "insert into ActualTripStopInfo(TripNumber, Date, "
              + "ScheduledStartTime, StopNumber) VALUES (?, ?, ?, ?)";
        PreparedStatement ps
         = connection.prepareStatement(query);
        ps.setInt(1, a.getTripNumber());
        ps.setString(2, a.getDate());
        ps.setString(3, a.getScheduledStartTime());
        ps.setInt(4, a.getStopNumber());
        
        int n = ps.executeUpdate();
        return n;
    }

    public int updateActualTripStopInfo(ActualTripStopInfo a) throws SQLException{
        String query
        = "UPDATE actualtripstopinfo SET ScheduledArrivalTime = ?, ActualStartTime = ?, ActualArrivalTime = ?, NumberOfPassengerIn = ?,"
        + " NumberofPassengerOut = ? "
        + "WHERE (TripNumber = ?) and (Date = ?) and (ScheduledStartTime = ?) and (StopNumber = ?)";
        PreparedStatement ps
         = connection.prepareStatement(query);
        ps.setString(1, a.getScheduledArrivalTime());
        ps.setString(2, a.getActualStartTime());
        ps.setString(3, a.getActualArrivalTime());
        ps.setInt(4, a.getNumberOfPassengerIn());
        ps.setInt(5, a.getNumPassengerOut());
        ps.setInt(6, a.getTripNumber());
        ps.setString(7, a.getDate());
        ps.setString(8, a.getScheduledStartTime());
        ps.setInt(9, a.getStopNumber());
        int n = ps.executeUpdate();
        return n;
    }
}
