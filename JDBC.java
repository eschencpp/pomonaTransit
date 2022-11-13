import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * JDBC
 */
public class JDBC {
    public static void main(String[] args) {

        try {
            Bus bus1 = new Bus("dawd");
           // BusDao busDao = new BusDao();
            //busDao.add(bus1);

            // //Test driver entity
            // Driver driver1 = new Driver(1);
            // DriverDao driverDao = new DriverDao();
            // driverDao.add(driver1);

            Stop stop = new Stop(2, "chino2");
            //stopDao stopDao = new stopDao();
           // stopDao.add(stop);

            TripOfferingDao tripOfferDao = new TripOfferingDao();

            tripOfferDao.showOfferings("california", "chino", "05/22/2022");
            
            tripOfferDao.displayStops(1);
        } catch (SQLException e) {
            System.out.println("SQL error");
        }
    
    }
}