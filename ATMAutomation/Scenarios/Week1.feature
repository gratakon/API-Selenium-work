Feature: Week1 Automated test suite


#update timings
#Rome, Metropolitan City of Rome, Italy
@VehiclemaintenanceTests_123
Scenario: TC_01_PRECONDITION Driver to book a vehicle trip during below hours for MONO-PARKING
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Booking section
	Then Select Schedule a return trip option for MonoParking 
	And Provide travel going to as "Rome, Metropolitan City of Rome, Italy" and Departure from as "RM, Roma, Viale Luca Gaurico 187" 
	And Provide Departure month as "Nov 2022" day as "14" hours as "01" minutes as "00" and click NEXT button to Book a car 
	Then Select the Vehicle and Click on forward 
	And Provide the Booking reason and Confirm Booking 
	And Logout of Driver Account
		
#Same timing as above pre-condtion
@VehiclemaintenanceTests
Scenario: TC_01_CS to put on maintenance a vehicle with an already scheduled trip for the time chosen 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page 
	And Customer service search for the Vehicle "YU890RT" and Click on view button
	Then Customer service enter the Maintaince Start Month as "July 2021" and Start Day as "05" and Start time as "01:00" 
	And Customer service enter the Maintaince End Month as "July 2021" and End Day as "05" and End time as "02:00" 
	Then Customer service will select the maintaince Reason as "Vehicle washing                " and Save the Maintaince Request 
	And Logout of Customer Service Account 
	
@VehiclemaintenanceTests
Scenario: TC_01_Driver to verify new vehicle is assigned to the same trip 
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
	And Navigate to My Trips section 
	Then Verify new vehicle is assigned to the same trip
	And Logout of Driver Account
	
@Fleetoverview123	
Scenario: TC_02_FM to visualize the condition list of his own fleet and of a specif vehicle through the filter 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Fleet overview page 
	Then View the total conditions with the number of reports and click view full list 
	And On vehicle condition page search for plate "EW768ME" and view the results only specific to that vehicle plate
	And Logout of Fleet Manager Account
	
@Fleetoverview
Scenario: TC_03_CS is able to visualize the whashing request of the whole fleet
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials
    When Navigate to Assistant owner and overview page 
    Then On OVERVIEW ASSISTANCE OWNER page click view complete list under Cleaning section
    And On Cleaning page search with the Plate "EW768ME" and View the list of vehicles for washing for that particular customer 
    And Logout of Customer Service Account
    
@Fleetoverview
Scenario: TC_04_CS is able to visualize the overall conditions of the whole fleet
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials
    When Navigate to Assistant owner and overview page 
    Then View the total conditions with the number of reports and click view full list 
	And On vehicle condition page search for plate "EW768ME" and view the results only specific to that vehicle plate
    And Logout of Customer Service Account
 
@CSMTests 
Scenario: TC_05_the customer service manager is able to create a new customer service user
    Given Login as a Customer Service Manager with "serena.toto@aldautomotive.com" and "Password.1" credentials
	Then Navigate to Customer service Users page
	And Customer service manager click on add the Customer operator
	Then Customer service manager cancel to add the Cusomter operator
	When Again add customer operator with Name as "Guru" Surname as "Ratakonda" and EmailID as "kiranguru488@gmail.com"
	Then Customer service manager search for the cusomer operator "kiranguru488@gmail.com"
	And Logout of Customer service manager Account
	   


Scenario: TC_07_the customer service manager is able to search for  an already created customer service user in the list
    Given Login as a Customer Service Manager with "serena.toto@aldautomotive.com" and "Password.1" credentials
	Then Navigate to Customer service Users page
	And Customer service manager search for the cusomer operator "Kiranguru488@gmail.com"
	And Logout of Customer service manager Account
	
@CSMTests
Scenario: TC_06_the customer service manager is able to delete  an already created customer service user
    Given Login as a Customer Service Manager with "serena.toto@aldautomotive.com" and "Password.1" credentials
	Then Navigate to Customer service Users page
	And Customer service manager search for the cusomer operator "Kiranguru488@gmail.com"
	Then Customer service manager delete the Customer operator 
	And Logout of Customer service manager Account
	
@CarPoolingTests
Scenario: TC_08_Customer Service is able to activate Car pooling option for a specific customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Carpooling option and Save changes 
	And Logout of Customer Service Account 

@CarPoolingTests
Scenario: TC_09_The driver who belongs to a customer with car pooling enabled is able to visualize his personal profile updated with car pooling info
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Car Sharing profile section 
	Then Verify Car Pooling option is enabled 
	And Logout of Driver Account  
 
@CarPoolingTests 
Scenario: TC_10_Customer Service is able to disable Car pooling option for a specific customer  (without scheduled trips)
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service disable the Carpooling option and Save changes 
	And Logout of Customer Service Account 
	
@CarPoolingTests 
Scenario: TC_11_The driver who belongs to a customer with car pooling disabled is not able to visualize his personal profile updated with car pooling info
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Car Sharing profile section 
	Then Verify Car Pooling option is Disabled 
	And Logout of Driver Account    
       
@CarPoolingTests

Scenario: TC_12_Customer Service is able to Deactivate Car pooling option for a specific customer (with scheduled trips)
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service disable the Carpooling option and Save changes 
	And Logout of Customer Service Account 
	
@CarPoolingTests
Scenario: TC_13_the driver who belongs to a customer with car pooling disabled is not able to visualize his personal profile updated with car pooling info
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Car Sharing profile section 
	Then Verify Car Pooling option is Disabled 
	And Logout of Driver Account   
 
@CarPoolingTests_FM
Scenario: TC_15_PRECONDITION Customer service Activate MultiParking option for the Customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account   
    
@CarPoolingTests_FM    
Scenario: TC_15_PRECONDITION Customer Service is able to Deactivate Car pooling option for a specific customer
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service disable the Carpooling option and Save changes 
	And Logout of Customer Service Account 

@CarPoolingTests_FM
Scenario: TC_15_FM is able to visualize the correct sections with multiparking enabled and car pooling not enabled
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 	
	And Navigate to Configuration and Settings page
	Then Verify Carpooling tab is not displayed for Fleet Manager on settings page
	And Logout of Fleet Manager Account

@CarPoolingTests_FM
Scenario: TC_16_PRECONDITION Customer service Activate MultiParking option for the Customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account 

@CarPoolingTests_FM
Scenario: TC_16_PRECONDITION_Customer Service is able to Activate Car pooling option for a specific customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Carpooling option and Save changes 
	And Logout of Customer Service Account 

@CarPoolingTests_FM
Scenario: TC_16_FM is able to visualize the correct sections with multiparking enabled and car pooling not enabled
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 	
	And Navigate to Configuration and Settings page
	Then Verify Carpooling tab is displayed for Fleet Manager on settings page
	And Logout of Fleet Manager Account	

@MultiparkingenableTests
Scenario: TC_17_Customer service Activate MultiParking option for the Customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account 

@CustomerList_download
Scenario: TC_19_CS is able to visualize the fleet manager list for a specific customer and to donwload it
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
    Then Search for the customer "test" and Activate the customer
    And List of Fleet Managers corresponding to the chosen customer is shown and download the list
    And Logout of Customer Service Account

@DriveraloginTests
Scenario: TC_20_Driver correctly registered is able to login to the platform
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials  
	And Logout of Driver Account

@DriveraloginTests
Scenario: TC_21_Driver correctly registered entering wrong Username is not able to login to the platform
	Given Login as a Driver with "testautomationccs+driv@gmail.com" and "Carsharing2!" credentials  
	And Validate Bad credentials error message displayed for wrong username

@DriveraloginTests
Scenario: TC_21_Driver correctly registered entering wrong Password is not able to login to the platform
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials  
	And Validate Bad credentials error message displayed for wrong password

@DriveraloginTests
Scenario: TC_23_the driver correctly logged in the platform is able to log out
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials  
	And Logout of Driver Account 
	 