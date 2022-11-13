import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

public class TripOfferingDao {
    DatabaseConnect conn = new DatabaseConnect();
    Connection connection = conn.getConnection();

    /**
    * Add a set of trip offerings assuming the values of all attributes are given
    */
    public int add(TripOffering tripOffer)throws SQLException {
        String query
            = "insert into tripOffering(TripNumber, Date, ScheduledStart, ScheduledArrival, DriverName, BusID)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setInt(1, tripOffer.getTripNumber());
        ps.setString(2, tripOffer.getDate());
        ps.setString(3, tripOffer.getScheduledStart());
        ps.setString(4, tripOffer.getScheduledArrival());
        ps.setString(5, tripOffer.getDriverName());
        ps.setInt(6, tripOffer.getBusID());
        int n = ps.executeUpdate();
        return n;
    }

    /**
    * Delete a trip offering specified by Trip#, Date, and ScheduledStartTime;  
    */
    public int delete(int tripNum, String date, String startTime) throws SQLException{
        String query
            = "DELETE FROM tripOffering WHERE TripNumber = ? AND Date = ? AND ScheduledStart = ?";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setInt(1, tripNum);
        ps.setString(2, date);
        ps.setString(3, startTime);
        int n = ps.executeUpdate();
        return n;
    }

    /**
    * Change the driver for a given Trip offering  
    */
    public int updateDriver(String newDriver, int tripNum, String date, String startTime)throws SQLException{
        String query
            = "UPDATE tripoffering SET DriverNum = ? WHERE (Date = ?) and (ScheduledStart = ?) and (TripNumber = ?)";
        PreparedStatement ps
         = connection.prepareStatement(query);
        ps.setString(1, newDriver);
        ps.setString(2, date);
        ps.setString(3, startTime);
        ps.setInt(4, tripNum);
        int n = ps.executeUpdate();
        return n;
    }


    /**
    * Change the bus for a given Trip offering 
    */
    public int updateBus(int newBusID, int tripNum, String date, String startTime) throws SQLException{
        String query
            = "UPDATE tripoffering SET BusID = ? WHERE (Date = ?) and (ScheduledStart = ?) and (TripNumber = ?)";
        PreparedStatement ps
         = connection.prepareStatement(query);
        ps.setInt(1, newBusID);
        ps.setString(2, date);
        ps.setString(3, startTime);
        ps.setInt(4, tripNum);
        int n = ps.executeUpdate();
        return n;
    }

    /**
    * Display the schedule of all trips for a given StartLocationName and Destination Name, 
    * and Date. In addition to these attributes, the schedule includes: Scheduled StartTime,  
    * ScheduledArrivalTime , DriverID, and BusID.   
    */

    public void showOfferings(String startLocation, String destination, String date) throws SQLException{
        String query
            = "SELECT tr.* "
            + "FROM tripOffering tr, Trip t "
            + "WHERE tr.TripNumber = t.TripNumber AND "
            + "t.StartLocationName = ? AND "
            + "t.DestinationName = ? AND "
            + "tr.Date = ?;";
        PreparedStatement ps
        = connection.prepareStatement(query);
        ps.setString(1, startLocation);
        ps.setString(2, destination);
        ps.setString(3, date);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1){
                System.out.print(",  ");
            }
            String columnValue = rs.getString(i);
            System.out.print(rsmd.getColumnName(i) + " " + columnValue);
        }
        System.out.println("");
        } 
    }

    /**
    * Display the schedule of all trips for a given StartLocationName and Destination Name, 
    * and Date. In addition to these attributes, the schedule includes: Scheduled StartTime,  
    * ScheduledArrivalTime , DriverID, and BusID.   
    */
    public void displayStops(int tripNum) throws SQLException{
        String query
            = "SELECT ts.StopNumber "
            + "FROM TripStopInfo ts "
            + "WHERE ts.TripNumber = ?";
        PreparedStatement ps
        = connection.prepareStatement(query);
        ps.setInt(1, tripNum);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
            String columnValue = rs.getString(i);
            System.out.print(columnValue + ", ");
        }
        
        } 
    }

    
}