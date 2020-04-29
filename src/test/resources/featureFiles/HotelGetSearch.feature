Feature: Hotel search Get service tests

@smokeTest
Scenario Outline:  Users are able to search hotels from system
	Given the tajawal application is available
	When user send the search Hotel request for destination "<destination>"
	Then verify Status code of response is 200 Ok
	And verify user get expected response "<expectedResponse>"
	Examples:
		|destination  |expectedResponse|
		|    paris    |hotelGetSearchExpectedResults|