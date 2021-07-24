
package Model;

/**
 This class defines Customer objects.
 @author Sean
 */
public class Customer {
    
    private int id;
    private String name;
    private String address;
    private String zipCode;
    private String phoneNum;
    private Country country;
    private FirstLevelDivision division;
    
    // with id, for updating
    public Customer(int id, String name, String address, String zipCode, String phoneNum, Country country, FirstLevelDivision division) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNum = phoneNum;
        this.country = country;
        this.division = division;
    }
    
    // No ID, for adding/creating Customers
    public Customer(String name, String address, String zipCode, String phoneNum, Country country, FirstLevelDivision division) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNum = phoneNum;
        this.country = country;
        this.division = division;
    }
    
    /**
     This method sets the given Customer object's id.
     @param id the id to set for this Customer object.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     This method sets the given Customer object's name.
     @param name the name to set for this Customer object.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     This method sets the given Customer object's address.
     @param address the address to set for this Customer object.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     This method sets the given Customer object's zipCode.
     @param zipCode the zipCode to set for this Customer object.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    /**
     This method sets the given Customer object's phoneNum.
     @param phoneNum the phoneNum to set for this Customer object.
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    /**
     This method sets the given Customer object's division.
     @param division the division to set for this Customer object.
     */
    public void setDivision(FirstLevelDivision division) {
        this.division = division;
    }
    
    /**
     This method sets the given Customer object's associated Country object.
     @param country the Country object to set for this Customer object.
     */
    public void setCountry(Country country) {
        this.country = country;
    }
    
    /**
     This method gets the given Customer object's id.
     @return id the id to return.
     */
    public int getId() {
        return this.id;
    }
    
    /**
     This method gets the given Customer object's name.
     @return name the name to return.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     This method gets the given Customer object's address.
     @return address the address to return.
     */
    public String getAddress() {
        return this.address;
    }
    
    /**
     This method gets the given Customer object's zipCode.
     @return zipCode the zipCode to return.
     */
    public String getZipCode() {
        return this.zipCode;
    }
    
    /**
     This method gets the given Customer object's phoneNum.
     @return phoneNum the phoneNum to return.
     */
    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    /**
     This method gets the given Customer object's division.
     @return division the division to return.
     */
    public FirstLevelDivision getDivision() {
        return this.division;
    }
    
    /**
     This method gets the given Customer object's Country object.
     @return country the Country object to return.
     */
    public Country getCountry() {
        return this.country;
    }
    
    /**
     Overriden toString method. Prints the Customer object's name.
     @return name the name of the Customer to return.
     */
    @Override
    public String toString() {
        return name;
    }
}
