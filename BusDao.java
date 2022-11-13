import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class BusDao {
    DatabaseConnect conn = new DatabaseConnect();
    Connection connection = conn.getConnection();

    public int add(Bus bus)
        throws SQLException
    {
        String query
            = "insert into bus(BusID, "
              + "plate) VALUES (?, ?)";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setString(1, bus.getBus_id());
        ps.setString(2, "VIN2323");
        int n = ps.executeUpdate();
        return n;
    }

    public void delete(String busid)
        throws SQLException
    {
        String query
            = "delete from bus where busID =?";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ps.setString(1, busid);
        ps.executeUpdate();
    }

    public ArrayList<Bus> getBusList()
        throws SQLException
    {
        String query = "SELECT * FROM pomonatransit.bus";
        PreparedStatement ps
            = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Bus> ls = new ArrayList();
  
        while (rs.next()) {
            Bus bus = new Bus();
            //Get data from DB and set object attributes
            bus.setBus_id(rs.getString("BusID"));
            bus.setPlate(rs.getString("plate"));
            bus.setYear(rs.getString("year"));
            bus.setMake(rs.getString("make"));

            //Add the bus object to list
            ls.add(bus);
        }
        return ls;
    }


}
