import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {

    private static String username = "root";
    private static String password = "1234";
    private static String url = "jdbc:mysql://localhost:3306/pomonaTransit";
    private static Connection con = null;
    
    static{
        try {
            con = DriverManager.getConnection(url, username, password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public static Connection getConnection(){
        return con;
    }
}
