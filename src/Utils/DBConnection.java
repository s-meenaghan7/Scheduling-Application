
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sean
 */
public class DBConnection {
    
    // JDBC URL parts
    private static final String PROTOCOL = "jdbc";
    private static final String VENDOR = ":mysql:";
    private static final String HOST = "//wgudb.ucertify.com:3306/";
    private static final String DATABASE = "WJ06FWN";
    
    // JDBC URL: jdbc:mysql://wgudb.ucertify.com/WJ06FWN + ?autoReconnect=true
    private static final String JDBCURL = PROTOCOL + VENDOR + HOST + DATABASE + "?autoReconnect=true";
    
    // Driver and connection interface references
    private static final String MYSQLJDBCDRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;
    
    // DB username & password
    private static final String USERNAME = "U06FWN";
    private static final String PASSWORD = "53688749476";
    
    public static Connection startConnection() {
        try {
            Class.forName(MYSQLJDBCDRIVER);
            conn = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void closeConnection() {
        try {
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {}
        
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
}
