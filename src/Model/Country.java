
package Model;

/**
 This class defines Country objects.
 @author Sean
 */
public class Country {
    
    private int id;
    private String country;
    
    public Country(int id, String country) {
        this.id = id;
        this.country = country;
    }

    /**
     This method gets this Country object's id.
     @return id the id to return from this Country object.
     */
    public int getId() {
        return id;
    }

    /**
     This method sets the ID for a given Country object.
     @param id the id to set for this Country object.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     This method gets this Country object's country name.
     @return country the country name to return from this Country object.
     */
    public String getCountry() {
        return country;
    }

    /**
     This method sets the country name for a given Country object.
     @param country the country name to set for this Country object.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     This overriden toString() method ensures that Country objects are displayed as their name and not a member reference.
     @return country the country name to return when displaying Country objects.
     */
    @Override
    public String toString() {
        return country;
    }
}
