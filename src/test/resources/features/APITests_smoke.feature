Feature: Users API Test
  Description: Here we test the High level health check of the API

  @api_test
  Scenario: Smoke test - POST - Correct Postcode
    Given I use "base-postcode-check" API end point
    When I POST a request using "W6 0NW"
    Then I get success response "200" code
    And response contains correct structure for the user end point response

  @api_test
  Scenario Outline: Smoke test - POST basic - Incorrect PostCode
    Given I use "base-postcode-check" API end point
    When I POST a request using "<postcode>"
    Then I get success response "<statusCode>" code
    And I get error message as "<errorMessage>"

    Examples:
    |postcode   |statusCode| errorMessage|
    |B99 9AA    |433 |Problem with Geocode API: Unable to find that address.|
    |EC1A 1BB   |435 |Invalid Address|
    |GARBAGE_CODE|435|Invalid Address|