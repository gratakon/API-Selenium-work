Feature: Week4 Automated test suite 

Scenario: TC_01_The CS is able to activate MultiParking option for a spcific customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account
	
Scenario: TC_01_The CS is able to activate car pooling option for a spcific customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Carpooling option and Save changes 
	And Logout of Customer Service Account 
	
Scenario: TC_02_The driver who belongs to the customer for which Carpooling is enabled can access Schedule a return trip option
	Given Login as a Driver with "testautomationccs+driver1@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Booking section 
	Then Select Schedule a return trip option for MonoParking 
	And Logout of Driver Account
	
Scenario: TC_02_The driver who belongs to the customer for which Multiparking is enabled can access Leave Now option
	Given Login as a Driver with "testautomationccs+driver1@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Booking section 
	Then Select Leave now option for MultiParking
	And Logout of Driver Account

Scenario: TC_03_Pre-requsit_The FM is able to ENABLE Multiparking option on Fleet page
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
	Then Select "Convertible and spider" option from SEGMENT dropdown and enable Multiparking option
	And Logout of Fleet Manager Account


Scenario: TC_03_PRE-CONDITION_The driver is able to book a trip under MULTI-PARKING
	Given Login as a Driver with "testautomationccs+driver1@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Booking section 
	Then Select Leave now option for MultiParking
	And Provide travel Departure as "RM, Roma, Viale Luca Gaurico 187" and Going to as "FI, Firenze, Viale dei Mille, 4" and click NEXT button
	Then Verify CAR CATEGORY that suits is displayed as expected and click on forward 
	And Provide the Booking reason and Confirm Booking 
	And Logout of Driver Account

Scenario: TC_03_The CS is not able to disable multiparking if there are car booking that are about to start 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service disable the Multiparking option and Save changes 
	Then Verify the Error message to change multi parking due to Departing vehicles is displayed 
	And Logout of Customer Service Account 


Scenario: TC_05_The CS is able to disable multiparking for a specific customer
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test Flow B" name 
	And Customer service disable the Multiparking option and Save changes 
	And Logout of Customer Service Account
	

Scenario: TC_06_The FM is not able to visualize the column multiparking in Fleet if multiparking is not enabled 
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
    And Verify multiparking option is not dispayed on Fleet page
    And Logout of Fleet Manager Account 	


Scenario: TC_07_PRE-CONDITION_The CS is able to Enable multiparking for a specific customer
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test Flow B" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account


Scenario: TC_07_The FM is able to visualize the column multiparking in Fleet if multiparking is enabled 
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
    And Verify multiparking option dispayed on Fleet page
    And Logout of Fleet Manager Account 
 
   
Scenario: TC_08_The CS is able to search a specific hub parking 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Multiparking page
	Then Search for the parking area "Corso di Francia"
	And Logout of Customer Service Account

	
Scenario: TC_09_The CS is able to modify a previously created hub parking
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Multiparking page
	Then Search for the parking area "Corso di Francia"
	And Click on three dots
	Then Click on edit button on the popup and verify edit parking page displayed
	And Logout of Customer Service Account
			
Scenario: TC_11_The CS is able to visualize the details of a previously created hub parking
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Multiparking page
	Then Search for the parking area "Corso di Francia"
	And Click on three dots	
	Then Click on edit button on the popup
	And Click on the pencil Edit
	Then Click on cancel button
	And Logout of Customer Service Account


Scenario: TC_12_The CS is able to change some feautures of a spefic hub parking 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Multiparking page
	Then Search for the parking area "Corso di Francia"
	And Click on three dots	
	Then Click on edit button on the popup
	And Click on the pencil Edit
	Then Enter the company "Test automation" to associate with the car park and Click search button
	And Press Save parking
	And Logout of Customer Service Account
	

Scenario: TC_13_The CS is able to create a new hub parking 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Multiparking page
	Then Click on Add a new car park
	And Fill the address field as "Brisbane, Brisbane City, Roma Street, 2"
	Then Fill Total parking spaces available as "2"
	And Click on the pencil Edit
	Then Enter the company "Test automation" to associate with the car park and Click search button
	And Press Save parking
	And Logout of Customer Service Account


Scenario: TC_10_The CS is able to delete a previously created hub parking
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Multiparking page
	Then Search for the parking area "Roma Street"
	And Click on three dots	
	Then Click on Remove button
	And Click on Cancel button on Delete parking pop up
	And Click on three dots	
	Then Click on Remove button
	And Click on confirm button on Delete parking pop up
	And Logout of Customer Service Account


Scenario: TC_14_The CS is able to search for a specific vehicle through the plate 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page 
	And Customer service search for the Vehicle "YU890RT"
	And Logout of Customer Service Account


Scenario: TC_15_The CS is able to search for a specific vehicle through brand 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page 
	And Customer service search for the Vehicle "Ford"
	And Logout of Customer Service Account

	
Scenario: TC_16_18__The CS is able to search for a specific vehicle through multiple filters_Download filtered results
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page	
	And Filter by multiple criteria Customer as "Test automation" Vehicle as "Ford" Status as "Not in use"
	Then Click on the DOWNLOAD button below vehicle results
	And Logout of Customer Service Account
	
Scenario: TC_17_The CS is able to download a list of all the vehicles for all the fleets
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page	
	Then Click on the DOWNLOAD button below vehicle results
	And Logout of Customer Service Account	

	
Scenario: TC_19_The FM is able to access to the page General fleet status
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and General Fleet status page
	And Logout of Fleet Manager Account
		
	
Scenario: TC_20_The FM is able to serach a specific vehicle through the plate
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and General Fleet status page
	Then Select Vehicle parking area as "All parkings"
	Then Type in a LISCENCE PLATE number as "ER566YY" and click on Filter button
	And Logout of Fleet Manager Account
	
#@VehiclemaintenanceTests
#choose the maintaince date which can be visible as a RED SQUARE on the same page
#Vehicle washing                g
#YU890RT SD4444FF WE345YT QW444RT
Scenario: TC_21_PRECONDITION The FM is able to visualize the vehicle under maintenance 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page 
	And Customer service search for the Vehicle "WE345YT" and Click on view button
	Then Customer service enter the Maintaince Start Month as "January 2020" and Start Day as "17" and Start time as "01:00" 
	And Customer service enter the Maintaince End Month as "January 2020" and End Day as "17" and End time as "02:00" 
	Then Customer service will select the maintaince Reason as "Vehicle washing                " and Save the Maintaince Request 
	And Logout of Customer Service Account 

#Vehicle plate number choose others if it is used in WEEK-1 execution
@testtesttest
Scenario: TC_21_The FM is able to visualize the vehicle under maintenance 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and General Fleet status page
	Then Select Vehicle parking area as "All parkings"
	Then Type in a LISCENCE PLATE number as "WE345YT" and click on Filter button
	And Press on the red square in the table and view Pop up with vehicle name 
	And Logout of Fleet Manager Account
	
Scenario: TC_22_The FM is able to search a specific vehicle through the model
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and General Fleet status page
	Then Select Vehicle parking area as "All parkings"
	Then Type in a MODEL as "NIRO" and click on Filter button
	And Logout of Fleet Manager Account
	
Scenario: TC_23_The FM is able to serach a specific vehicle through the multiple criteria
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and General Fleet status page
	Then Select Vehicle parking area as "RM, Roma, Viale Luca Gaurico 187"
	Then Type in a LISCENCE PLATE number as "ET470BB" and click on Filter button
	And Logout of Fleet Manager Account

	
Scenario: TC_24_The FM is able to see the header even if he scrolls down the visualization
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and General Fleet status page	
	Then Scroll down the screen to the bottom of the vehicle list
	And Verify the header of the table containing the days of the week is always visible at the top of the window
	And Logout of Fleet Manager Account
	
	
Scenario: TC_25_The FM is able to search a vehicle by plate in Fleet 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
	Then In the Registration field provide License Plate number as "WE345YT" and click on filter
	And Logout of Fleet Manager Account

Scenario: TC_26_The FM is able to visualize the details of the maintenance inserted by cs
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page 
	And Customer service search for the Vehicle "YU890RT" and Click on view button
	Then Customer service will select the maintaince Reason
	And Logout of Customer Service Account 
	
#@VehiclemaintenanceTests
#Other                r
#YU890RT SD4444FF WE345YT ER566YY QW444RT
Scenario: TC_27_The CS is able to put a vehicle in maintenance with other as reason 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page 
	And Customer service search for the Vehicle "QW444RT" and Click on view button
	Then Customer service enter the Maintaince Start Month as "November 2020" and Start Day as "19" and Start time as "01:00" 
	And Customer service enter the Maintaince End Month as "November 2020" and End Day as "19" and End time as "02:00" 
	Then Customer service will select the maintaince Reason as "Other                " and Save the Maintaince Request 
	And Logout of Customer Service Account 

	
Scenario: TC_28_The FM is able to viusalize the list of parking in a precise requested order
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and General Fleet status page	
	Then Select the dropdown All car parkings and verify list of car park addresses is displayed in in alphabetical order
	And Logout of Fleet Manager Account
	 
#Booking made in TC_03_Precondition will fail below test - Customer should not be Test automation 
Scenario: TC_29_1_PRECONDITION_The CS is able to DISABLE multi-parking for a customer  
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test flow B" name 
	And Customer service disable the Multiparking option and Save changes 
	And Logout of Customer Service Account 


Scenario: TC_29_1_The FM is able to visualize the correct sections according to multiparking disabled 
	Given Login as a Fleet Manager with "testautomationccs+fmb@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
	Then Verify multiparking option is not dispayed on Fleet page
	And Logout of Fleet Manager Account 
	
Scenario: TC_29_2_PRECONDITION_The CS is able to ENABLE multi-parking for a customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account 


Scenario: TC_29_2_The FM is able to visualize the correct sections according to multiparking enabled 
	Given Login as a Fleet Manager with "Testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
	Then Verify multiparking option dispayed on Fleet page
	And Logout of Fleet Manager Account 


Scenario: TC_29_3_4_5_PRECONDITION_The FM is able to visualize the correct sections according to multiparking enabled 
	Given Login as a Fleet Manager with "Testautomationccs+a@gmail.com" and "Carsharing2!" credentials  
	And Navigate to Configuration and Fleet page
	Then Search "QW444RT" vehicle registration number and enable Multiparking option
	And Logout of Fleet Manager Account 
	

Scenario: TC_29_3_4_5_The FM is able to visualize the correct sections according to multiparking Disabled 
	Given Login as a Fleet Manager with "Testautomationccs+a@gmail.com" and "Carsharing2!" credentials  
	And Navigate to Configuration and Fleet page
	Then Search "QW444RT" vehicle registration number and disable Multiparking option
	And Logout of Fleet Manager Account 

#SeprateRun -run only if there is no booking 
#Customer Service has enabled the customer to multi-park
#Vehicle with multi-parking attribute
#Reservation made
#Active travel start countdown  
#Scenario: TC_30_PRE-CONDITION_The driver is able to book a trip under MULTI-PARKING
#	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
#	And Navigate to Booking section 
#	Then Select Leave now option for MultiParking
#	And Provide travel Departure as "RM, Roma, Viale Luca Gaurico 187" and Going to as "FI, Firenze, Viale dei Mille, 4" and click NEXT button
#	Then Verify CAR CATEGORY that suits is displayed as expected and click on forward 
#	And Provide the Booking reason and Confirm Booking 
#	And Logout of Driver Account
 
#SeprateRun
Scenario: TC_30_PRECONDITION_Driver to verify new vehicle is assigned to the same trip 
	Given Login as a Driver with "testautomationccs+driver1@gmail.com" and "Carsharing2!" credentials 
	And Navigate to My Trips section 
	Then Verify new vehicle is assigned to the same trip
	And Logout of Driver Account

#SeprateRun	
Scenario: TC_30_The FM is not able to disable multiparking for a a specific vehicle if a multiparking trip is about to start 
	Given Login as a Fleet Manager with "Testautomationccs+a@gmail.com" and "Carsharing2!" credentials  
	And Navigate to Configuration and Fleet page
	Then Search for vehicle registration number with Reservation made and disable Multiparking option
	Then Verify the Multiparking checkbox disabled due to scheduled trip booking
	And Logout of Fleet Manager Account


Scenario: TC_31_PRECONDITION_The CS is able to ENABLE multi-parking for a customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account 

	
Scenario: TC_31_The FM is able to visualize the Current parking status page if multiparking is active
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	And Logout of Fleet Manager Account
	
	
Scenario: TC_32_The FM is able to visualize the Traveling vehicles tab
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Vehicle in Transit tab
	And Logout of Fleet Manager Account

	
Scenario: TC_33_The FM is able to visualize the tab related to the vehicles still in a parking
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Vehicle in Parking area tab
	And Logout of Fleet Manager Account
	

Scenario: TC_34_The FM is able to visualize the tab related to the vehicles in maitenance
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Vehicle Undergoing Maintenance tab
	And Logout of Fleet Manager Account


Scenario: TC_35_The FM is able to filter the current status parking page
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Filters button on CURRENT STATUS OF PARKING AREAS page
	And Click on Apply Filters button CURRENT STATUS OF PARKING AREAS page
	#to verify no error message 
	Then Click on Vehicle in Transit tab
	And Logout of Fleet Manager Account

	
Scenario: TC_36_The FM is able to filter the current status parking page by type of service
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Filters button on CURRENT STATUS OF PARKING AREAS page
	And Select the Service Type dropdown
	And Click on Apply Filters button CURRENT STATUS OF PARKING AREAS page
	#Below extra step is to see the some search results
	Then Click on Vehicle in Parking area tab
	And Logout of Fleet Manager Account

	
Scenario: TC_37_The FM is able to filter the current status parking page by type of segment
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Filters button on CURRENT STATUS OF PARKING AREAS page
	And Select the Vehicle Segment checkbox option for CONVERTIBLE and PREMIUM
	And Click on Apply Filters button CURRENT STATUS OF PARKING AREAS page
	#Below extra step is to see the some search results
	Then Click on Vehicle in Parking area tab
	And Logout of Fleet Manager Account

	
Scenario: TC_38_The FM is able to filter the current status parking page by parking
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Filters button on CURRENT STATUS OF PARKING AREAS page
	And Select the Vehicle Parking area dropdown
	And Click on Apply Filters button CURRENT STATUS OF PARKING AREAS page
	#Below extra step is to see the some search results
	Then Click on Vehicle in Parking area tab
	And Logout of Fleet Manager Account

	
Scenario: TC_39_The FM is able to filter the current status parking page by trip type
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	When Navigate to Configuration and Monitoring and Current status of Parking area page
	Then Click on Filters button on CURRENT STATUS OF PARKING AREAS page
	And Select the Trip type checkbox as Business
	And Click on Apply Filters button CURRENT STATUS OF PARKING AREAS page
	#Below extra step is to see the some search results
	Then Click on Vehicle in Parking area tab
	And Logout of Fleet Manager Account

#Pre-condtion customer should be enabled for multiparking	
Scenario: TC_40_The FM is able to visualize the Notification management page if multi-parking is enabled	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Alert Management tab
	And Logout of Fleet Manager Account

	
Scenario: TC_41_The FM is not able to activate a specific notification without specifying an email	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Alert Management tab
	Then Under FLEET LOCATION SECTION Set ON when notification is received
	And Under FLEET LOCATION SECTION Choose a number of vehicles present
	But Under FLEET LOCATION SECTION Do not insert mail Click on SAVE button
	Then Under FLEET LOCATION SECTION Validate mail Mandatory message will display
	And Logout of Fleet Manager Account

	
Scenario: TC_42_The FM is able to receive an alert for fleet displacement	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Alert Management tab
	Then Under FLEET LOCATION SECTION Set ON when notification is received
	And Under FLEET LOCATION SECTION Choose a number of vehicles present
	But Under FLEET LOCATION SECTION Insert mail Click on SAVE button
	Then Under FLEET LOCATION SECTION Validate Success message displayed as expected
	And Logout of Fleet Manager Account

	
Scenario: TC_43_The FM is not able to activate a specific notification without specifying an email	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Alert Management tab
	Then Under EMPTY PARKING SECTION Set ON when notification is received
	And Under EMPTY PARKING SECTION Choose a number of vehicles present
	But Under EMPTY PARKING SECTION Do not insert mail Click on SAVE button
	Then Under EMPTY PARKING SECTION Validate mail Mandatory message will display
	And Logout of Fleet Manager Account

	
Scenario: TC_44_The FM is able to receive an alert for empty parking	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Alert Management tab
	Then Under EMPTY PARKING SECTION Set ON when notification is received
	And Under EMPTY PARKING SECTION Choose a number of vehicles present
	But Under EMPTY PARKING SECTION Insert mail Click on SAVE button
	Then Under EMPTY PARKING SECTION Validate Success message displayed as expected
	And Logout of Fleet Manager Account
	
	
Scenario: TC_45_The FM is not able to activate a specific notification without specifying an email
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Alert Management tab
	Then Under UNUSED VEHICLE SECTION Set ON when notification is received
	And Under UNUSED VEHICLE SECTION Choose a number of vehicles present
	But Under UNUSED VEHICLE SECTION Do not insert mail Click on SAVE button
	Then Under UNUSED VEHICLE SECTION Validate mail Mandatory message will display
	And Logout of Fleet Manager Account

	
Scenario: TC_46_The FM is able to receive an alert for unused vehicle	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Alert Management tab
	Then Under UNUSED VEHICLE SECTION Set ON when notification is received
	And Under UNUSED VEHICLE SECTION Choose a number of vehicles present
	But Under UNUSED VEHICLE SECTION Insert mail Click on SAVE button
	Then Under UNUSED VEHICLE SECTION Validate Success message displayed as expected
	And Logout of Fleet Manager Account


Scenario: TC_47_The FM is able to visualize the Analytics	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	Then Verify Use of parking lots tab and MAINTENANCE tab on Analytics page
	And Logout of Fleet Manager Account

	
Scenario: TC_48_The FM is able to viualize the maintenance section in Analytics	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	Then On the Analytics page select Maintenance
	And Logout of Fleet Manager Account	
	
	
Scenario: TC_49_The FM is able to check that hub parking are not present in the list_Maintenance section	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	Then On the Analytics page select Maintenance
	Then Verify hub parking options are not present in Parking dropdown list
	And Logout of Fleet Manager Account	
	
	
Scenario: TC_50_The FM is able to check the search buttons_Maintenance section
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	Then On the Analytics page select Maintenance
	Then Verify search button disabled when one of the three search parameters is not selected
	Then Select the Parking option
	Then Provide month as "Nov 2019" day as "25" in the FROM field
	Then Provide month as "Nov 2020" day as "25" in the TO field
	Then Verify search button is enabled and Click if enabled
	And Logout of Fleet Manager Account


Scenario: TC_51_The FM is able to visualize all the maintenances in a a specific timeslot_Maintenance section
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	Then On the Analytics page select Maintenance
	Then Verify search button disabled when one of the three search parameters is not selected
	Then Select the Parking option
	Then Provide month as "Nov 2019" day as "25" in the FROM field
	Then Provide month as "Nov 2020" day as "25" in the TO field
	Then Verify search button is enabled and Click if enabled
	Then Verify Button to download the table on XLS click on EXPORT XLS button
	And Logout of Fleet Manager Account
		

Scenario: TC_53_The FM is able to visualize the parking use section
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	And Logout of Fleet Manager Account

	
Scenario: TC_54_The FM is able to check that hub parking are not present in the list_UseOfParkingLot Section	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	Then Verify hub parking options are not present in Parking dropdown list
	And Logout of Fleet Manager Account	

	
Scenario: TC_55_The FM is able to check the search buttons_UseOfParkingLot Section	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials
	When Navigate to Configuration and Monitoring and Analytics page
	Then Verify search button disabled when one of the three search parameters is not selected
	Then Select the Parking option
	Then Provide month as "Nov 2020" day as "25" in the FROM field
	Then Provide month as "Nov 2020" day as "25" in the TO field
	Then Verify search button is enabled and Click if enabled
	And Logout of Fleet Manager Account	
	

Scenario: TC_56_The FM is able to set 4 limits (one per each graphic) 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Analytics Tab
	Then Provie all the data on Analytics page
	And Logout of Fleet Manager Account
	

Scenario: TC_58_The FM is not able to set a string insted of a number 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Click on Analytics Tab
	Then Enter a string for each numeric value
	Then Verify that an error message appears
	And Logout of Fleet Manager Account
	

Scenario: TC_59_The FM is able to visualize the travel list page 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to TravelList section
	And Logout of Fleet Manager Account
	
	
Scenario: TC_60_The FM is able to visualize the travel list page - nest trips
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials  
	And Navigate to TravelList section 
	Then On Next trips Tab and click on search
	And Logout of Fleet Manager Account
	

Scenario: TC_61_The FM is able to visualize the travel list page - nest trips
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials  
	And Navigate to TravelList section 
	Then Click on Past trips Tab and click on search
	And Logout of Fleet Manager Account
	

Scenario: TC_62_The FM is able to filter by plate
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials  
	And Navigate to TravelList section 
	Then Enter the correct license plate code as "YU890RT" and press Search
	And Logout of Fleet Manager Account

	
Scenario: TC_63_The FM is able to filter by usage type
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials  
	And Navigate to TravelList section 
	Then Select the Type of use as "Private" and press Search
	And Logout of Fleet Manager Account


Scenario: TC_68_The CS is able to update the info on vehicle closure without keys for a specific vehicle 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	Then Customer service navigate to All Vehicles page 
	And Customer service search for the Vehicle "AA111BB" and Click on view button
	Then On vehicle details page select Allow trips to be closed even if the key is not in the repository box as YES
	And Logout of Customer Service Account
	

Scenario: TC_69_The FM is able to visualize the option about the closure of the trip without keys	
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then Verify Allow the closure of trips even if the key is not in the repository is disabled
	And Logout of Fleet Manager Account


Scenario: TC_70_The CS is able access the maintenance badge 
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials
    When Navigate to Assistant owner and Maintenance badges page
	And Logout of Customer Service Account
	

Scenario: TC_71_The CS is able to update the maintenance hour 
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials
    When Navigate to Assistant owner and Maintenance badges page
    Then Select Duration in hours of the maintenance as "2h" and click on Save
	And Logout of Customer Service Account	


Scenario: TC_72_The CS is able to insert a new maintenance badge
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials
    When Navigate to Assistant owner and Maintenance badges page
    Then Enter ChipId BadgeId Assignee and Customer and press save
	And Logout of Customer Service Account	



Scenario: TC_73_The CS is able to insert a new maintenance badge
    Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials
    When Navigate to Assistant owner and Maintenance badges page
    Then Select customer and press Search
	And Logout of Customer Service Account	
	
@testingtest
Scenario: TC_74_The FM is able to search a specific driver by last name
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to DriverManagement page
	Then Search with Drivers LastName as "Luca"
	And Logout of Fleet Manager Account	

@testingtest
Scenario: TC_75_The FM is able to search a specific driver by surname
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to DriverManagement page
	Then Search with Drivers SurName as "Antonucci"
	And Logout of Fleet Manager Account
	
@testingtest
Scenario: TC_76_The FM is able to search a specific driver by email
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to DriverManagement page
	Then Search with Drivers EmailID as "luca.antonucci+testfix1@doing.com"
	And Logout of Fleet Manager Account
	
	
@testingtest
Scenario: TC_77_The FM is able to visualize the driver management page
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to DriverManagement page 
	And Logout of Fleet Manager Account
	
Scenario: TC_79_The FM is able vsualize the hub parking if multiparking is enabled
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Search for a specific parking space "Viale Luca Gaurico, 187, Rome, Metropolitan City of Rome, Italy"
	And Logout of Fleet Manager Account 