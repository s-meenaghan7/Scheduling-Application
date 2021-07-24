# Scheduling-Application
Timekeeping / appointment scheduling application written in Java.

IDE: Apache Netbeans v12.3

Java version "11.0.10" 2021-01-19 LTS

JavaFX API of version 15.0.1 by JavaFX runtime of version 11.0.2

MySQL Connector Driver version: 8.0.22

This Java application is used to keep track of customer information and their appointments for a company. The application connects to a MySQL database to retrieve relevant data regarding customer and appointment information. User login data (credentials) is also held in the database. Data access objects are responsible for performing CRUD operations on the database's tables to retrieve, add, update, and delete information used in the application.

================================================================

Directions: 


Login:

When the program starts, a connection to the database is established and the login screen appears. User credential information is stored on the database and only authorized users can log in. After an authorized user's credentials are entered and accepted, the main screen will appear. A prompt will appear each time a user logs in, informing the user if there is or is not an appointment set to occur within 15 minutes of their local time.

Main screen:

On the main screen, two tables are populated with information, one for appointments and one for customers. Appointment times are displayed using the user's local time on their 
computer. Each appointment will have exactly one customer associated with it. Appointments can be added, modified, or deleted from the database. In the appointment's table pane, three radio buttons allow the user to filter the appointments to display only appointments for the current week, month, or all appointments in the database. In the Customer table, each customer record is shown. Customers can also be added, modified, or deleted from the database.

Refresh button:

Sometimes, if a user spends too much time on a screen other than the main screen, and then navigates back to the main screen, the connection to the database will time out. This may cause appointment and/or customer information to not populate their tables. To restore connection to the database, the user simply needs to click the refresh button. The connection to the database will be restored and information should populate the main screen's tables correctly.

Add Customer or Appointment:

To add a customer or appointment, the user must first select the 'Add' button associated with either the customer table or appointment table. The user will be brought to a screen where they can enter information regarding the new customer or appointment. If a field is left blank or the entered information is not applicable, the program will alert the user to this, prompting them to make the appropriate changes. Finally, the user may save the new customer or appointment to the database with the 'Save' button.

Update Customer or Appointment:

To update a customer or appointment, the user must first select either a customer or appointment from their respective table and click 'Update'. The user will be brought to a screen identical to the 'Add' screens and the selected customer or appointment's information will be prepopulated in the fields. If the user decides to not make changes, selecting the 'Cancel' button will bring them back to the main screen without making any changes. If changes are made and the user is done making changes, the 'Save' button will save any updates made to the customer or appointment.

Delete Customer or Appointment:

To delete a customer or appointment, the user must first select either a customer or appointment from their respective table and click 'Delete'. A confirmation prompt will appear to ensure this is the correct action, allowing the user to confirm or cancel the delete. If the user attempts to delete a customer with existing appointments in the database, the program will alert the user to this and prevent the customer from being deleted, until it's associated appointments are deleted first.

Reports:

At the top of the main screen, there a three reports that the user can run on the current database information. Each report button brings the user to a different screen to view
report information.
	
Report 1 - Total Customer Appointments by Type and Month:

This screen will allow the user to select a month from a drop-down menu and view information for appointments that month. A text label will display the total number of appointments scheduled for that month. A table will break down the type of appointments and the number of appointments for that type.

Report 2 - Contact Scheduling:

The contact scheduling report screen allows the user to display only appointments for the selected contact (Contacts are company representatives who meet with a customer in each appointment). The user selects a contact and the table is populated with that contact's appointments.

Report 3 - Customer Scheduling:

The customer scheduling report screen allows the user to display only appointments for the selected customer. Similar to the contact scheduling report, the user simply selects a customer from the drop-down menu, causing the table to populate with only that customer's appointments.
