Feature: Hotel Search Post Service Tests
	This feature includes tests that test the search hotel RESTFul service
# Validation type one where we can match response as single entity and match it with saved expected response
@smokeTest
Scenario Outline:  Users are able to search hotels from system
	Given the tajawal application is available
	When user send the search Hotel request with "<fromDate>" till "<toDate>" and room config "<roomConfig>"
	Then verify Status code of response is 200 Ok
	And verify user get expected response "<expectedResponse>"
	Examples:
		|fromDate         |toDate         |roomConfig                            |expectedResponse                  |
	    |    11-09-2020   | 12-09-2020    |   twoRoomsFourAdultsOneChildThree    |hotelPostSearchExpectedResults|

# Validation type two, where we can test specific fields from request vs response
@smokeTest
Scenario Outline:  Verify the response with specific details
	Given the tajawal application is available
	When user send the search Hotel request with "<fromDate>" till "<toDate>" and room config "<roomConfig>"
	Then verify Status code of response is 200 Ok
	And verify user get expected response as per the given request
	And verify type of the Response is 'hotel'
	And verify placeID at request and response is matching
	Examples:
	|fromDate         |toDate         | roomConfig                           |
	|    11-09-2020   | 13-09-2020    |   twoRoomsFourAdultsOneChildThree    |

