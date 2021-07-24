
package DAO;

import Model.Country;
import Model.Customer;
import Model.FirstLevelDivision;
import Model.User;
import Utils.DBConnection;
import Utils.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 This class is responsible for data access methods of Customer object information from a MySQL database.
 @author Sean
 */
public class DBCustomers {
    
    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    
    /**
     This method is responsible for querying the database for Customer record information from the customers table, creating a Customer object for each 
     record found, and storing this information in the program's memory.
     @throws SQLException the potential SQLException that must be caught or declared to be thrown.
     */
    public static void setAllCustomers() throws SQLException {
        // Get the Connection object to connect w/ DB
        Connection conn = DBConnection.getConnection();
        allCustomers.clear(); // to prevent duplicates
        
        // SQL Statement for finding all customers and their relevant information
        String selectStatement = "SELECT customers.Customer_ID, customers.Customer_Name, customers.Address, customers.Postal_Code, customers.Phone, first_level_divisions.Division, countries.Country "
                               + "FROM customers JOIN first_level_divisions on customers.Division_ID=first_level_divisions.Division_ID JOIN countries on countries.Country_ID=first_level_divisions.COUNTRY_ID";
        
        // Prepared Statement
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
       
        // Prepared Statement executed and returned to a ResultSet
        ps.execute();
        ResultSet rs = ps.getResultSet();
        
        while (rs.next()) {
            // Assign each column value to a variable to load into the Customer constructor
            int id = rs.getInt("Customer_ID");
            String name = rs.getString("Customer_Name");
            String address = rs.getString("Address");
            String zipCode = rs.getString("Postal_Code");
            String phoneNum = rs.getString("Phone");
            String countryName = rs.getString("Country");
            String divisionName = rs.getString("Division");
            
            // determine country and division objects here based on the above strings, by filtering a stream of allCountries
            Country country = DBCountries.getAllCountries().stream().filter(c -> c.getCountry().equals(countryName)).findAny().orElseThrow();
            
            FirstLevelDivision division = DBDivisions.getAllDivisions().stream().filter(d -> d.getDivision().equals(divisionName)).findAny().orElseThrow();
            
            // create a new Customer object, using the above variables to define it's fields
            Customer customer = new Customer(id, name, address, zipCode, phoneNum, country, division);
            
            allCustomers.add(customer);
        }
        
    }
    
    /**
     This method returns all Customer objects from the program's memory.
     @return the ObservableList of Customer objects that is returned. 
     */
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    /**
     This method is responsible for a SQL INSERT INTO operation to store a new Customer object into the database.
     @param newCustomer the new Customer object to be added to the database
     @throws SQLException the potential SQLException that must be caught or declared to be thrown.
     */
    public static void addCustomer(Customer newCustomer) throws SQLException {
        allCustomers.add(newCustomer);
        
        // Get the Connection object to connect w/ DB
        Connection conn = DBConnection.getConnection();
        
        //INSERT SQL Statement to add this customer to the DB
        String sql = "INSERT INTO customers(Customer_Name, Address, Postal_Code, Phone, Created_By, Last_Updated_By, Division_ID) "
                   + "VALUES(" + "'" + newCustomer.getName() + "', "
                               + "'" + newCustomer.getAddress() + "', "
                               + "'" + newCustomer.getZipCode() + "', "
                               + "'" + newCustomer.getPhoneNum() + "', "
                               + "'" + User.user.getUsername() + "', "
                               + "'" + User.user.getUsername() + "', "
                                     + newCustomer.getDivision().getDivId() + ")";
        
        // Prepared Statement
        DBQuery.setPreparedStatement(conn, sql);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        
        // Prepared Statement executed, add customer to DBCustomers allCustomers
        ps.execute();
    }
    
    /**
     This method is responsible for sending a SQL DELETE FROM statement to the database to delete the specified appointment record. Returns false if
     a SQLIntegrityConstraintViolationException is thrown, due to referential integrity constraints between the customers and appointments database tables.
     @param customer the Customer object being deleted from the database.
     @return true returns true if no referential integrity constraints are violated by the DELETE FROM statement.
     @throws SQLException the potential SQLException that must be caught or declared to be thrown.
     */
    public static boolean deleteCustomer(Customer customer) throws SQLException {
        // connect to the DB to remove the customer from the DB
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM customers WHERE Customer_ID=" + customer.getId();
        
        try {
            // Prepared Statement
            DBQuery.setPreparedStatement(conn, sql);
            PreparedStatement ps = DBQuery.getPreparedStatement();

            // Prepared Statement executed and returned to a ResultSet
            ps.execute();
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        }    
        // remove the customer from the ObservableArrayList
        allCustomers.remove(customer);
        return true;
    }
    
    /**
     This method is responsible for sending a SQL UPDATE command to the database to update a current Customer record.
     @param customer the Customer object being updated in the database.
     @throws SQLException the potential SQLException that must be caught or declared to be thrown.
     */
    public static void updateCustomer(Customer customer) throws SQLException {
        // the updated customer object is passed in as parameter customer
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE customers " + 
                     "SET Customer_Name=" + "'" + customer.getName() + "', " +
                     "Address=" + "'" + customer.getAddress() + "', " +
                     "Postal_Code=" + "'" + customer.getZipCode() + "', " +
                     "Phone=" + "'" + customer.getPhoneNum() + "', " +
                     "Last_Updated_By=" + "'" + User.user.getUsername() + "', " +
                     "Last_Update=now(), " +
                     "Division_ID=" + customer.getDivision().getDivId() + " " +
                     "WHERE Customer_ID = " + customer.getId();
        
        // Prepared Statement
        DBQuery.setPreparedStatement(conn, sql);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        
        // Prepared Statement executed, add customer to DBCustomers allCustomers
        ps.execute();
        
    }
}
