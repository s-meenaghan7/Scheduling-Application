
package Model;

/**
 This class defines FirstLevelDivision objects.
 @author Sean
 */
public class FirstLevelDivision {
    
    private int divId;
    private String division; // ie state name
    private int countryId;
    
    public FirstLevelDivision(int divId, String division, int countryId) {
        this.divId = divId;
        this.division = division;
        this.countryId = countryId;
    }

    /**
     This method returns the FirstLevelDivision object's division id.
     @return divId the division id to return.
     */
    public int getDivId() {
        return divId;
    }

    /**
     This method sets the given FirstLevelDivision object's division id.
     @param divId the divId to set for this FirstLevelDivision object.
     */
    public void setDivId(int divId) {
        this.divId = divId;
    }

    /**
     This method returns the FirstLevelDivision object's division name.
     @return division the division name to return.
     */
    public String getDivision() {
        return division;
    }

    /**
     This method sets the given FirstLevelDivision object's division name.
     @param division the division name to set.
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     This method returns the FirstLevelDivision object's Country id.
     @return countryId the countryId to return.
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     This method sets the given FirstLevelDivision object's country id.
     @param countryId the countryId to set.
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    
    /**
     Overriden toString method to print the FirstLevelDivision object's division name.
     @return division the division name to return.
     */
    @Override
    public String toString() {
        return division;
    }
    
}
