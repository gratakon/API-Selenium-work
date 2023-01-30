Feature: Week2 Automated test suite 

#Clear all Badges under Badges section as a pre-requsit

@FM_abcd
Scenario: TC_01_The Fleet manager is able to access to electric settings and change the percentage for the maintenance 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Settings page
	Then On Generale Tab update the charging to "20%" and maintaince hours to "1" and Save Changes 
	And Logout of Fleet Manager Account 
		
@FM_Badge
Scenario: TC_02_The FM is able to access to BADGE section and to visualize the information regarding the parking to which associate the badges
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM downloads the badge upload template by clicking on DOWNLOAD TEMPLATE
	And FM click on the View parking codes link
	And Logout of Fleet Manager Account
	
@FM_Badge
Scenario: TC_03_The FM is able to check that hub parkings are not available for the association of badges
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	And FM click on the View parking codes link
	Then Verify The HUB parking lots are not displayed in the modal
	And Logout of Fleet Manager Account
	
@FM_Badge
Scenario: TC_04_The FM is able to remove a file before uploading it
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM is able to Choose a file to upload
	And FM is able to remove a file before uploading it
	And Logout of Fleet Manager Account

@FM_Badge
Scenario: TC_05_The FM is able to upload a file with correct data
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM is able to Choose a file to upload and click on Upload button
	And Verify confirmation flash message is displayed
	And Logout of Fleet Manager Account
	
@FM_Badge
Scenario: TC_05_To verify the newly created Badge is assigned to the Driver
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to DriverManagement page
	Then Verify badge has been correctly assigned to the driver
	And Logout of Fleet Manager Account
	
@FM_Badge
Scenario: TC_11_The FM is able to visualize the upload Driver has already a badge
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM is able to Choose a file with Driver already assigned and click on Upload button
	And Verify Driver has Badge assigend message is displayed
	And Logout of Fleet Manager Account

@FM_Badge
Scenario: TC_06_The FM is able to upload a file with incorrect data
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM is able to Choose a file with wrong data to upload and click on Upload button
	And Verify all the checks are carried out on the data entered
	And Logout of Fleet Manager Account

@FM_Badge
Scenario: TC_07_08_09_10_The FM is able to upload a file with Bad data[CardID, ChipID, DriverEmail, Parkingcode]
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM is able to Choose a file with wrong CARDID CHIPID DriverMAILID and PARKINGCODE data to upload and click on Upload button
    And Verify all the error messages are displayed under wrong values
    Then Edit all the uploaded wrong values and click on upload again
    And Verify confirmation flash message is displayed
    And Logout of Fleet Manager Account
     
@FM_Badge
Scenario: TC_12_The FM is able to delete wrong associations
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then Click on the trash can icon to delete the wrongly inserted badge "1234"
	And Logout of Fleet Manager Account
		
@FM_Badge
Scenario: TC_13_The FM is able change wrongly inserted driver info
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM is able to change driver info previously inserted to "testautomationccs+drivera3@gmail.com"
	And Logout of Fleet Manager Account

@FM_Badge
Scenario: TC_14_The FM is able to search for a specific driver or association through Search
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM is able to search for a specific driver or association as "1111" through Search
	And Logout of Fleet Manager Account
	
@FM_Badge
Scenario: TC_15_The FM is able to cancel the deletion for an association
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then Click on the trash can icon to delete the wrongly inserted badge "7890" but cancel the deletion
	And Logout of Fleet Manager Account
		
@FM_Badge
Scenario: TC_16_The FM is able to bulk delete the badges
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM selects DELETE BADGE option and apply under Massive options section
	And Logout of Fleet Manager Account
	
@FM_Badge
Scenario: TC_17_The FM is able to bulk change the parking
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Badges page
	Then FM selects CHANGE PARKING option and apply under Massive options section
	And Logout of Fleet Manager Account
	
@FM_Badge
Scenario: TC_27_The FM is able to accomplish bulk actions on drivers
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to DriverManagement page
	Then On Enable Tab Select MassiveOptions and Assign the group to all the drivers
	And Click on Cancel
	Then On Enable Tab Select MassiveOptions and Assign the group to all the drivers
	And Click on Confirm
	And Logout of Fleet Manager Account
	
@FM_ParkingAndHours
Scenario: TC_18_The FM is able to access to Parking and hours page to create a new parking 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Click on Add new Parking space
	And Cancel Add new parking space
	Then Click on Add new Parking space
	And Enter the required data for new parking space and press Save Changes
	And Logout of Fleet Manager Account

@FM_ParkingAndHours
Scenario: TC_19_The FM is able to add opening and closing time for the parking previously created 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then FM click on ADD SCHEDULE button for the newly created parking Space
	And Cancel the Add schedule
	Then FM click on ADD SCHEDULE provide the timings and Save changes
	And Logout of Fleet Manager Account
	
@FM_ParkingAndHours
Scenario: TC_20_The FM is able to export all the parkings created 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Click on GET PARKING DATA to download the parking data
	And Logout of Fleet Manager Account

@FM_ParkingAndHours
Scenario: TC_21_The FM is able to search for a specific parking
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Search for a specific parking space "Rome Metropolitan Guesthouse, Via Milazzo, Rome, Rome, Metropolitan City of Rome, Italy"
	And Logout of Fleet Manager Account

#Not required if Week-1 Test cases are executed prior
#@FM_ParkingAndHours
#Scenario: TC_22_PRECONDITION_The FM is not able to delete a parking with vehicle if there are ongoing trips booked
#	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
#	And Navigate to Booking section
#	Then Select Schedule a return trip option for MonoParking 
#	And Provide travel going to as "Rome, Metropolitan City of Rome, Italy" and Departure from as "RM, Roma, Viale Luca Gaurico 187" 
#	And Provide Departure month as "Oct 2020" day as "29" hours as "01" minutes as "00" and click NEXT button to Book a car 
#	Then Select the Vehicle and Click on forward 
#	And Provide the Booking reason and Confirm Booking 
#	And Logout of Driver Account

#pre-requisit there should be a trip booked to the below parking run those tests	
@FM_ParkingAndHours
Scenario: TC_22_The FM is not able to delete a parking with vehicle if there are ongoing trips booked
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Search for a specific parking space "Viale Luca Gaurico, 187, Rome, Metropolitan City of Rome, Italy"
	And Click on REMOVE Parking space and verify the popup message related to vehicle with ongoing trip booked is displayed
	And Logout of Fleet Manager Account
	
@FM_ParkingAndHours
Scenario: TC_22_The FM is not able to delete a parking with vehicle associated
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Search for a specific parking space "Via di Fraviano, 5, Fraviano, Trentino, Italy"
	And Click on REMOVE Parking space and verify the popup message related to associated vehicle is displayed
	And Logout of Fleet Manager Account

@FM_ParkingAndHours
Scenario: TC_23_The FM is able to cancel a parking with associated badge removing them
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Search for a specific parking space "Viale delle Rimembranze di Greco, 3, Milan, Metropolitan City of Milan, Italy"
	And Click on remove parking space
	Then Check the Delete badge check box activates the Confirm Removal button
	And Click on Cancel button
	And Logout of Fleet Manager Account

@FM_ParkingAndHours
Scenario: TC_24_The FM is able to remove the parking changing the parking association for the badges
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Search for a specific parking space "Viale delle Rimembranze di Greco, 3, Milan, Metropolitan City of Milan, Italy"
	And Click on remove parking space
	Then Check the checkbox Assign them to another car park and Select parking
	And Verify Confirm Reassignment button enabled
	And Click on Cancel button
	And Logout of Fleet Manager Account
		
#@CleanTestData
#Scenario: POST_TEST_Clear_data_The FM is able to delete wrong associations
#   Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
#	And Navigate to Configuration and Badges page
#	Then Click on the trash can icon to delete the wrongly inserted badge "7890"
#	And Logout of Fleet Manager Account	

@CleanTestData
Scenario: POST_TEST_Clear_data_The FM is able to delete a parking 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Search for a specific parking space "Rome Metropolitan Guesthouse, Via Milazzo, Rome, Rome, Metropolitan City of Rome, Italy"
	And Click on remove parking space
	Then Click on Confirm parking space deletion
	And Logout of Fleet Manager Account
	

#TC_25_is default set values 
#Choose tuesdays as travel booking day
@UsageAndHours123
Scenario: TC_25_26_the driver is not able to book a private trip in the same timeslot changed by FM
	Given Login as a Driver with "testautomationccs+driver@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Booking section
	Then Select Schedule a return trip option for MonoParking 
	And Select Private booking
	And Provide travel going to as "Rome, Metropolitan City of Rome, Italy" and Departure from as "FI, Firenze, Piazzale Michelangelo" 
	And Provide Departure month as "Nov 2020" day as "17" hours as "01" minutes as "00" and click NEXT button 
	Then Verify no vehicles are available during provided booking period
	And Logout of Driver Account

@FM
Scenario: TC_28_PRECONDITION_The CS is able to DISABLE multi-parking for a customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service disable the Multiparking option and Save changes 
	And Logout of Customer Service Account 

@FM
Scenario: TC_28_The FM is able to visualize the correct sections under Fleet page according to multiparking not enabled
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
	Then Verify multiparking option is not dispayed on Fleet page
	And Logout of Fleet Manager Account 
	
@FM
Scenario: TC_28_The FM is able to visualize the correct sections on Parking and Hours page according to multiparking not enabled
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Verify multiparking option is not displayed on Parking and hours page
	And Logout of Fleet Manager Account 

@FM
Scenario: TC_29_the CS is able to ENABLE multi-parking for a customer 
	Given Login as a Customer Service with "Testautomationccs+cs@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Customer Management section 
	Then Search for the Customer "Test automation" name 
	And Customer service enable the Multiparking option and Save changes 
	And Logout of Customer Service Account 

@FM
Scenario: TC_30_The FM is able to visualize the hub parking after the multiparking enabling by CS 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Parking Hours
	Then Verify multiparking option displayed on Parking and hours page
	And Logout of Fleet Manager Account 

@FM_GroupsAndSegments
Scenario: TC_31_The FM is able to create a new driver group to associate segments
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Groups and Segments page
	Then Create a new group with Name as "TestingGroup1" Description as "TestingGrouspDes" and Segment as "Convertible and spider" Save changes
	And Logout of Fleet Manager Account
		
@FM_GroupsAndSegments
Scenario: TC_32_The FM is able to associate each driver to a specific group
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to DriverManagement page
	Then Assign the newly created Business Group "TestingGroup1" to driver "testautomationccs+driver1@gmail.com" and Save changes
	And Logout of Fleet Manager Account
	
@FM_GroupsAndSegments
Scenario: TC_34_The driver is able to book only the car in the segments avalaible for his specific group - mono-parking
	Given Login as a Driver with "testautomationccs+driver1@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Booking section 
	Then Select Schedule a return trip option for MonoParking 
	And Provide travel going to as "Rome, Metropolitan City of Rome, Italy" and Departure from as "RM, Roma, Viale Luca Gaurico 187" 
	And Provide Departure month as "Nov 2020" day as "18" hours as "01" minutes as "00" and click NEXT button to Book a car 	
	Then Verify CAR CATEGORY that suits is displayed as expected
	And Logout of Driver Account

@FM_GroupsAndSegments
Scenario: TC_33_Pre-requsit_The FM is able to ENABLE Multiparking option on Fleet page 
	Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Fleet page
	Then Select "Convertible and spider" option from SEGMENT dropdown and enable Multiparking option
	And Logout of Fleet Manager Account 
	
#Multiparking option enable - pre-requisit under fleet section
@FM_GroupsAndSegments
Scenario: TC_33_The driver is able to book only the car in the segments avalaible for his specific group - multi-parking
	Given Login as a Driver with "testautomationccs+driver1@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Booking section 
	Then Select Leave now option for MultiParking
	And Provide travel Departure as "RM, Roma, Viale Luca Gaurico 187" and Going to as "FI, Firenze, Viale dei Mille, 4" and click NEXT button
	Then Verify CAR CATEGORY that suits is displayed as expected
	And Logout of Driver Account
		
@FM_GroupsAndSegments
Scenario: TC_35_FM is able to delete a group already created 
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Groups and Segments page
	Then Delete the group with Name as "TestingGroup1" and assign the driver to group "Default"
	And Logout of Fleet Manager Account

@FM_GroupsAndSegments
Scenario: TC_36_FM is not able to delete the last group available
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Groups and Segments page
	#Then Delete the group with Name as "test"
	#And Verify the Error message The group cannot be deleted
	And Logout of Fleet Manager Account
