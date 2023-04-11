@E2E_APITests
Feature: API Automated test suite

@APIScenario_1
Scenario: TC_01_Add Place_Response Code validation 200 OK
#Given user generate qa authentication token for EISL endpoints
	When base uri is set for "BaseURI" endpoint
	And user set "Addplace" for endpoints
	#And user set authentication token generated in above step
	And user set "QUERY" parameter "key" as "qaclick123" for current endpoint
	And user add request json "AddPlaceAPI.json" to request body
	#And user set proxy details "10.98.21.24" host name and "8080" port
	And user execute "POST" request "with" json
	Then user verifies the response status code as "200"
	
@APIScenario_2
Scenario: TC_02_Get Place_Response Code validation 200 OK
#Given user generate qa authentication token for EISL endpoints
	When base uri is set for "BaseURI" endpoint
	And user set "Getplace" for endpoints
	#And user set authentication token generated in above step
	And user set "QUERY" parameter "key" as "qaclick123" for current endpoint
	And user set "QUERY" parameter "place_id" as "f187c313e01a6c4a4e67c5bf9673eedb" for current endpoint
	#And user set proxy details "10.98.21.24" host name and "8080" port
	And user execute "GET" request "without" json 
	Then user verifies the response status code as "200"
	
@APIScenario_3
Scenario: TC_03_Update Place_Response Code validation 200 OK
#Given user generate qa authentication token for EISL endpoints
	When base uri is set for "BaseURI" endpoint
	And user set "Updateplace" for endpoints
	#And user set authentication token generated in above step
	And user set "QUERY" parameter "key" as "qaclick123" for current endpoint
	And user add request json "UpdatePlaceAPI.json" to request body
	#And user set proxy details "10.98.21.24" host name and "8080" port
	And user execute "PUT" request "with" json 
	Then user verifies the response status code as "200"
	
#Scenario Outline: TC_03_Add Place_Response Code validation 200 OK 
# Given Read all the data from '<sheet>' in "TestDataInputsheet.xlsx" for "<ScenarioID>"
#	When base uri is set for "https://rahulshettyacademy.com" endpoint 
#	#And user set "/maps/api/place/add/json" for endpoints 
#	#And user set "QUERY" parameter "key" as "qaclick123" for current endpoint 
#	#And user add request json "AddPlaceAPI.json" to request body 
#	#And user execute "POST" request "with" json 
#	Then user verifies the response status code as "200"
#	
#	Examples:
#	|sheet| |ScenarioID|
#	|Valid| |TestdataTransaction_1|
	
	
	
