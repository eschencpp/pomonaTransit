import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

public class DriverDao {
    DatabaseConnect conn = new DatabaseConnect();
    Connection connection = conn.getConnection();

    //Add a driver to database
    public int add(Driver driver) throws SQLException {
        String query
            = "insert into driver(DriverName, telephone) VALUES (?,?)";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setString(1, driver.getDriver_id());
        ps.setString(2, driver.getTelephone());
        int n = ps.executeUpdate();
        return n;
    }

    //Display the weekly schedule of a given driver and date.
    public void showSchedule(String DriverName, String date) throws SQLException{
        String query
            = "SELECT  t.tripNumber, t.Date, t.ScheduledStart, t.ScheduledArrival, t.DriverName "
            + "FROM	TripOffering t, Driver d "
            + "WHERE	d.DriverName = t.DriverName AND "
            + "d.DriverName = ? AND "
            + "WEEK(t.Date) IN (SELECT WEEK(?));";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setString(1, DriverName);
        ps.setString(2, date);
        System.out.println(query);
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


}
