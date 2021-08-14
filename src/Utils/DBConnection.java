
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
    // NOTE: Host and database information has been removed from this public file, for security.
    private static final String PROTOCOL = "jdbc";
    private static final String VENDOR = ":mysql:";
    private static final String HOST;
    private static final String DATABASE;
    
    // Full JDBC URL format
    private static final String JDBCURL = PROTOCOL + VENDOR + HOST + DATABASE + "?autoReconnect=true";
    
    // Driver and connection interface references
    private static final String MYSQLJDBCDRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;
    
    // DB username & password
    // NOTE: Username and password are sensitive information and as such have been removed from this public file.
    private static final String USERNAME;
    private static final String PASSWORD;
    
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
