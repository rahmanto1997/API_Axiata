Feature: User functionality
  As a user
  I want to create user, get user, edit user, and delete user
  So that I am success goals mvp

  @CreateUser
  #Create User
  Scenario Outline: I want to create user
    Given I am create user
    When I am set body name "<name>" email "<email>" gender "<gender>" status "<status>"
    And I am hit endpoint
    Then I am get a status code 201
    Examples:
      | name    | email              | gender | status   |
      | hassimi | hassimi4@axiata.id | male   | inactive |

  @GetUser
  #Get User
  Scenario: I want to get user by ID
    Given I am to see user
    When I am hit endpoint get user
    Then I am get a status code 200

  @EditUser
  #Edit User
  Scenario Outline: I want to edit user data
    Given I am to edit user
    When I am set body name "<name>" email "<email>" gender "<gender>" status "<status>"
    And I am hit endpoint get user
    And I am hit endpoint edit user
    Then I am get a status code 200
    Examples:
      | name    | email              | gender | status |
      | hassimi | hassimi4@axiata.id | female | active |

  @DeleteUser
  #Edit User
  Scenario: I want to edit dele data
    Given I am to delete user
    When I am hit endpoint get user
    And I am hit endpoint delete user
    Then I am get a status code 204
