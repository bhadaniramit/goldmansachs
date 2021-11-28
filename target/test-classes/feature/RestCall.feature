Feature: This is to test the all the Rest Call

  Scenario: In this scenario, I will make a get call
    Given user make a get call without any parameter

  Scenario: In this scenario, I will make a get Call with Query Param
    Given user make a get call by using a query parameter


  Scenario: In this scenario, I will make a Post call by retrieving the data from Get Call
    Given user make a get call without any parameter
    And I will make a post call using the get data


    Scenario: This is to validate the Put Call
      Given user make a get call without any parameter
      And user will trigger the Put Call
