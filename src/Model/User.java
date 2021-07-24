
package Model;

/**
 This class defines User objects.
 @author Sean
 */
public class User {
    
    private final int id;
    private final String username;
    private final String password;
    
    public static User user;
    
    public User(int id, String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    
    /**
     This method returns this User's username
     @return username the username of this User to return.
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     This method returns this User's password.
     @return password the password of this User to return.
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     This method returns this User's id.
     @return id the id of this User to return.
     */
    public int getId() {
        return this.id;
    }
    
    /**
     This method overrides the Object class toString() method, displaying user information with the format "username (ID: userID)".
     @return String the String returned when displaying a user's information.
     */
    @Override
    public String toString() {
        return this.username + " (ID: " + this.id + ")";
    }
    
}
