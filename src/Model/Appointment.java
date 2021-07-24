
package Model;

import DAO.DBCustomers;
import DAO.DBUsers;
import java.util.List;
import java.time.LocalDateTime;

/**
 This class defines Appointment objects.
 @author Sean
 */
public class Appointment {
    
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private Contact contact;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private int customerId;
    private int userId;
    
    public Appointment(int appointmentId, String title, String description, String location, Contact contact, String type, LocalDateTime start, LocalDateTime end, int customerId, int userId) {
        this.appointmentId = appointmentId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerId = customerId;
        this.userId = userId;
    }
    
    // no ID, for adding/creating Appointments
    public Appointment(String title, String description, String location, Contact contact, String type, LocalDateTime start, LocalDateTime end, int customerId, int userId) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerId = customerId;
        this.userId = userId;

    }

    /**
     Returns this Appointment object's appointmentId
     @return appointmentId the appointment ID to return
     */
    public int getAppointmentId() {
        return appointmentId;
    }
    
    /**
     Sets this Appointment object's Appointment ID
     @param appointmentId the appointment ID to set for this Appointment object
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
     /**
     Returns this Appointment object's title
     @return title the appointment ID to return
     */
    public String getTitle() {
        return title;
    }

    /**
     Sets this Appointment object's title
     @param title the title to set for this Appointment object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     Returns this Appointment object's description
     @return description the description of this appointment object to return
     */
    public String getDescription() {
        return description;
    }

    /**
     Sets this Appointment object's description
     @param description the description to set for this Appointment object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     Returns this Appointment object's location
     @return location the location of this appointment object to return
     */
    public String getLocation() {
        return location;
    }

    /**
     Sets this Appointment object's location
     @param location the location to set for this Appointment object
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     Returns this Appointment object's contact
     @return contact the contact of this appointment object to return
     */
    public Contact getContact() {
        return contact;
    }

    /**
     Sets this Appointment object's contact
     @param contact the contact to set for this Appointment object
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     Returns this Appointment object's type
     @return type the type of this appointment object to return
     */
    public String getType() {
        return type;
    }

    /**
     Sets this Appointment object's type
     @param type the type to set for this Appointment object
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     Returns this Appointment object's start LocalDateTime
     @return start the LocalDateTime start of this appointment object to return
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     Sets this Appointment object's start LocalDateTime
     @param start the start to set for this Appointment object
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     Returns this Appointment object's end LocalDateTime
     @return end the LocalDateTime end of this appointment object to return
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     Sets this Appointment object's end LocalDateTime
     @param end the end to set for this Appointment object
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    
    /**
     Returns this Appointment object's userId.
     @return userId the userId of this Appointment object to return.
     */
    public int getUserId() {
        return this.userId;
    }
    
    /**
     This method uses the userId of this Appointment object to find the User it is associated with.
     @param userId the userId of the User being searched for.
     @return User the user associated with this Appointment, returned from its userId.
     */
    public User getUser(int userId) {
        return DBUsers.getAllUsers().stream().filter(user -> user.getId() == userId).findAny().orElseThrow();
    }

    /**
     Returns this Appointment object's customerId.
     @return customerId the customerId of this Appointment object to return.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     Sets this Appointment object's customerId
     @param customerId the customerId to set for this Appointment object
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    /**
     This method will find a customer from the collection of all customers contained in the program's memory, searching by customerID.
     @param customerId the customerId of the Customer object to search for and return.
     @return Customer the Customer object to return when found.
     */
    public Customer getCustomer(int customerId) {
        
        List<Customer> customersList = DBCustomers.getAllCustomers();
        
        for (Customer customer : customersList) {
            if (customer.getId() == customerId) return customer;
        }
        
        return null; // should never execute
    }
}
