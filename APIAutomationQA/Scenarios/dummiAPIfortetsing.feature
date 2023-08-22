@E2E_dummyuserAPITests
Feature: Dummy User API Automated test suite

@dummyapiscenario_1
Scenario: TC_01_Dummy User POST_Response Code validation 200 OK
	When base uri is set for "UserBaseURI" endpoint
	And user set "Userpost" for endpoints
	#And user set "QUERY" parameter "key" as "qaclick123" for current endpoint
	And user add request json "dummyuserPOST.json" to request body
	And user execute "POST" request "with" json
	Then user verifies the response status code as "201"
	
@dummyapiscenario_1
Scenario: TC_02_Dummy User GET_Response Code validation 200 OK
	When base uri is set for "UserBaseURI" endpoint
	And user set "Userpost" for endpoints
	#And user set "QUERY" parameter "key" as "qaclick123" for current endpoint
	And user execute "GET" request "without" json
	Then user verifies the response status code as "200"
	
	