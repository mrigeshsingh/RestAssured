Feature: Validating individual 301 page APIs

Scenario: Verify if members API is returning members Data
Given Get members Payload
When user calls "getMembers" with POST http request
Then the API call is success with status code 200
And "status" in response body is "OK"