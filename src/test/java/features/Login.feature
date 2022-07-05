Feature: Feature for Login against email and password
  Scenario Outline: This is just login test
    Given User wants to call the Login API
    When email is "<email>"
    And password is "<password>"
    Then login response should be "200"
    Examples:
      | email | password |
    |Rohit Sharma|Anything|
    |Ravikant Singh|AnythingMore|