
package Model;

/**
 This class defines Contact objects.
 @author Sean
 */
public class Contact {
    
    private int id;
    private String name;
    private String email;
    
    public Contact(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     This method gets the ID of this Customer object.
     @return id the Customer's ID to return.
     */
    public int getId() {
        return id;
    }

    /**
     This method sets the Id of this Customer object.
     @param id the id to set for this Customer object.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     This method gets the name of this Customer object.
     @return name the Customer's name to return.
     */
    public String getName() {
        return name;
    }

    /**
     This method sets the name of this Customer object.
     @param name the name to set for this Customer object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     This method gets the email of this Customer object.
     @return email the Customer's email to return.
     */
    public String getEmail() {
        return email;
    }

    /**
     This method sets the email of this Customer object.
     @param email the email to set for this Customer object.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     This overriden toString() method ensures that Customer objects, when displayed, are displayed by their name variable.
     @return name the name of the Customer object is returned when displayed.
     */
    @Override
    public String toString() {
        return name;
    }
}
