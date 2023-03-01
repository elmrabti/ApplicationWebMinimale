package util;
import java.sql.*;

public class OracleConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/orclpdb";
        String username = "elmrabti";
        String password = "hamza";

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Test the connection
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            
            Statement statement = connection.createStatement();
            String query = "select * from personne" ;
            ResultSet rs = statement.executeQuery(query) ;
            while(rs.next()) {
            	System.out.println( rs.getString("nom") );
            }

            // Close the connection
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the Oracle JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not connect to the database.");
            e.printStackTrace();
        }
    }
}