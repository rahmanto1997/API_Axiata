package starter.goals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.baseTest.baseTest;

public class goalSteps extends baseTest {
    @Given("I am create user")
    public void iAmCreateUser() {
    }

    @When("I am set body name {string} email {string} gender {string} status {string}")
    public void iAmSetBodyNameEmailGenderStatus(String name, String email, String gender, String status) {
        goals.setRequestBody(name, email, gender, status);
    }

    @And("I am hit endpoint")
    public void iAmHitEndpoint() {
        goals.hitEndpointSignup();
    }

    @Then("I am get a status code {int}")
    public void iAmGetAStatusCode(int statuscode) {
        goals.validateEndpoint(statuscode);
    }

    @Given("I am to see user")
    public void iAmToSeeUser() {
    }
    @When("I am hit endpoint get user")
    public void iAmHitEndpointGetUser() {
        goals.hitEndpointGetUser();
    }
    @Given("I am to edit user")
    public void iAmToEditUser() {
    }
    @And("I am hit endpoint edit user")
    public void iAmHitEndpointEditUser() {
        goals.hitEndpointEditUser();
    }

    @Given("I am to delete user")
    public void iAmToDeleteUser() {
    }

    @And("I am hit endpoint delete user")
    public void iAmHitEndpointDeleteUser() {
        goals.hitEndpointDeleteUser();
    }
}