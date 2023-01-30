Feature: Week3 Automated test suite 

#Clear all data on CostCenter pages as a pre-requsit



Scenario: TC_01_The CMS system operator is able to change the configuration related to the cost center upload
	Given Login as a Admin Config with "admin_config" and "+Eg7gIQA" credentials
	And Click on Platform configuration
	Then Enter the following parameter "Cost_center_association_type" and click on search
	And Click on the desired parameter line
	Then Select "userId" from Cost center association type Dropdown and Save the changes	
	And Logout of as Admin Config
	
@Costcenterpage_review
Scenario: TC_02_The FM is able to visualize and correct all the wrong asssociations uploaded with the csv file
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Upload the csv file contains driver userID and incorrect lines cdc
	But In correspondence with the associations in error click on the trash can icon
	Then Click on Upload and verify the success message 
	And Logout of Fleet Manager Account
	
@Costcenterpage_review
Scenario: TC_03_The FM is able to upload a csv file after visualising the correct id in the proper modal pooler[Pooler with valid UserID]
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Upload the csv file contains Pooler userID and correct lines cdc
	Then Click on Upload and verify the success message 
	And Logout of Fleet Manager Account

@Costcenterpage_review
Scenario: TC_04_The FM is not able to upload a file in a wrong format
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Upload the file with text format
	Then Click on Upload and verify the Error message is displayed
	And Logout of Fleet Manager Account
	
#taxCode
#userId
@AdminConfig_CostCenterAssosication
Scenario: TC_05_PRECONDITION_The CMS system operator is able to change the configuration related to the cost center upload
	Given Login as a Admin Config with "admin_config" and "+Eg7gIQA" credentials
	And Click on Platform configuration
	Then Enter the following parameter "Cost_center_association_type" and click on search
	And Click on the desired parameter line
	Then Select "taxCode" from Cost center association type Dropdown and Save the changes	
	And Logout of as Admin Config

@Costcenterpage_review
Scenario: TC_05_The FM is able to upload a correct file
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Upload the csv file contains Driver Taxcode and correct lines cdc
	Then Click on Upload and verify the success message 
	And Logout of Fleet Manager Account

@Costcenterpage_review
Scenario: TC_06_The FM has the chance to delete  the incorrect data inserted during the upload
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Upload the csv file contains driver Taxcode and incorrect lines cdc
	But In correspondence with the associations in error click on the trash can icon
	Then Click on Upload and verify the success message 
	And Logout of Fleet Manager Account

@Costcenterpage_review		
Scenario: TC_07_The FM is able to upload a correct file of Pooler with valid Taxcode
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Upload the csv file contains Pooler Taxcode and correct lines cdc
	Then Click on Upload and verify the success message 
	And Logout of Fleet Manager Account

#taxCode
#userId
@DriverModel_For_Import
Scenario: TC_08_PRECONDITION_The CMS system operator is able to change the configuration related to the cost center upload
	Given Login as a Admin Config with "admin_config" and "+Eg7gIQA" credentials
	And Click on Platform configuration
	Then Enter the following parameter "Cost_center_association_type" and click on search
	And Click on the desired parameter line
	Then Select "userId" from Cost center association type Dropdown and Save the changes	
	And Logout of as Admin Config

@DriverModel_For_Import
Scenario: TC_08_The FM is able to search a  specific user by name and surname in the proper filter- (user id)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the driver's first and last name as "TEST CS" and click on search
	Then The system correctly returns the search result
	#Then Close the Driver list model
	And Logout of Fleet Manager Account

@DriverModel_For_Import
Scenario: TC_09_The FM is able to search a  specific user by email  in the proper filter- (user id)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the driver's Email as "testautomationccs+driver1@gmail.com" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account	

@DriverModel_For_Import
Scenario: TC_10_The FM is able to search a  specific user by user id  in the proper filter- (user id
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the driver's UserID as "37" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account	

#taxCode
#userId
@DriverModel_For_Import
Scenario: TC_11_PRECONDITION_The CMS system operator is able to change the configuration related to the cost center upload
	Given Login as a Admin Config with "admin_config" and "+Eg7gIQA" credentials
	And Click on Platform configuration
	Then Enter the following parameter "Cost_center_association_type" and click on search
	And Click on the desired parameter line
	Then Select "taxCode" from Cost center association type Dropdown and Save the changes	
	And Logout of as Admin Config

@DriverModel_For_Import
Scenario: TC_11_The FM is able to search a  specific driver by name and surname in the proper filter- (tax code)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the driver's first and last name as "TEST DUE" and click on search
	Then The system correctly returns the search result
	#Then Close the Driver list model
	And Logout of Fleet Manager Account

@DriverModel_For_Import
Scenario: TC_12_The FM is able to search a  specific driver by email  in the proper filter- (tax code)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the driver's Email as "testautomationccs+drivera3@gmail.com" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account	

@DriverModel_For_Import
Scenario: TC_13_The FM is able to search a  specific driver by tax code  in the proper filter- (tax code)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the driver's Taxcode as "RRTYUI67Y67G222Q" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account
	
#taxCode
#userId
@poolerModel_For_Import
Scenario: TC_14_PRECONDITION_The CMS system operator is able to change the configuration related to the cost center upload
	Given Login as a Admin Config with "admin_config" and "+Eg7gIQA" credentials
	And Click on Platform configuration
	Then Enter the following parameter "Cost_center_association_type" and click on search
	And Click on the desired parameter line
	Then Select "userId" from Cost center association type Dropdown and Save the changes	
	And Logout of as Admin Config

@poolerModel_For_Import
Scenario: TC_14_The FM is able to search a  specific pooler by name and surname in the proper filter- (user id)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the Pooler's first and last name as "Pooler A" and click on search
	Then The system correctly returns the search result
	#Then Close the Driver list model
	And Logout of Fleet Manager Account

@poolerModel_For_Import
Scenario: TC_15_The FM is able to search a  specific pooler by email  in the proper filter- (user id)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the Poolers's Email as "testautomationccs+pooler1@gmail.com" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account	

@poolerModel_For_Import
Scenario: TC_16_The FM is able to search a  specific pooler by UserID  in the proper filter- (user id)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the Poolers's UserID as "22" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account	
	
#taxCode
#userId
@poolerModel_For_Import
Scenario: TC_17_PRECONDITION_The CMS system operator is able to change the configuration related to the cost center upload
	Given Login as a Admin Config with "admin_config" and "+Eg7gIQA" credentials
	And Click on Platform configuration
	Then Enter the following parameter "Cost_center_association_type" and click on search
	And Click on the desired parameter line
	Then Select "taxCode" from Cost center association type Dropdown and Save the changes	
	And Logout of as Admin Config

@poolerModel_For_Import
Scenario: TC_17_The FM is able to search a  specific pooler by name and surname in the proper filter- (tax code)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the Pooler's first and last name as "Test Pooler 2" and click on search
	Then The system correctly returns the search result
	#Then Close the Driver list model
	And Logout of Fleet Manager Account

@poolerModel_For_Import
Scenario: TC_18_The FM is able to search a  specific pooler by email  in the proper filter- (tax code)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the Poolers's Email as "testautomationccs+pooler2@gmail.com" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account	

@poolerModel_For_Import
Scenario: TC_19_The FM is able to search a  specific pooler by tax code  in the proper filter- (tax code)
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Driver list model on top right
	When User enter the Poolers's Taxcode as "TTYLIY67R56G456P" and click on search
	Then The system correctly returns the search result
	And Logout of Fleet Manager Account	
		
@GuideCDC
Scenario: TC_20_The FM is able to visualize a quick guide to better understand the page of the cost center
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on Help button on Costcenter page verify the content
	And Logout of Fleet Manager Account
	
@Modification_DriverCDC_Association
Scenario: TC_21_The FM is able to change a single association of a user
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on pencil icon and select new CDC value from the dropdown as "HR"
	And Logout of Fleet Manager Account

@Modification_DriverCDC_Association	
Scenario: TC_22_The FM is able to decide to not perform the single modification at the last moment
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Click on pencile icon and within the dropdownlist click on cancel corresponding to x
	And Logout of Fleet Manager Account
	
@Deletion_DriverCDC_Association
Scenario: TC_23_The FM is able to delete a single association
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then click on the delete icon next to an association and click on confirm
	And Logout of Fleet Manager Account

@BulkModify_DriverCDC_Association
Scenario: TC_24_the FM is able to  bulk change the cost center
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	Then Select from the massive action from the dropdown list and Select CdC to associate from the dropdown list of the CDC
	And Select one or more items in the list of associations displayed on the CDC page
	Then Click on Apply
	And Logout of Fleet Manager Account
	
@BulkDeletion_DriverCDC_Association	
Scenario: TC_25_the FM is able to  bulk delete the cost center
    Given Login as a Fleet Manager with "testautomationccs+a@gmail.com" and "Carsharing2!" credentials 
	And Navigate to Configuration and Cost centers page
	And Select one or more items in the list of associations displayed on the CDC page
	Then Click on Apply
	Then FM confirms the deletion
	And Logout of Fleet Manager Account
	
	

	
	
	
	
	
	
	

