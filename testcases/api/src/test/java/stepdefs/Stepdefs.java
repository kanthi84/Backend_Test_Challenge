package stepdefs;

import Utilities.Endpoints;
import Utilities.Support;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.http.ContentType.ANY;
import static io.restassured.http.ContentType.JSON;

public class Stepdefs {

private Support support = new Support();




    private Scenario scenario;

    @Before
    public void startUp(Scenario scenario)  throws Throwable {
        this.scenario = scenario;
    }

    @Given("I fetch the user (.*)")
    public void iFetchUserSamantha(String name) throws Throwable{
        support.isUserPresent(name);
    }

    @When("I fetch id for the User (.*)")
    public void iSearchForTheUserSamantha(String name) throws Throwable{
        support.fetchIdforUser(name);
    }

    @And("I fetch posts from (.*)")
    public void userDetailsFetched(String name) throws Throwable{
        support.fetchUserPosts(name);
    }

    @And("I retrieve comments for the posts from (.*)")
    public void iRetrieveCommentsForThePostsFromSamantha(String name) {
        support.retrieveUserComments(name);
    }

    @Then("I make sure email address for the comments displayed in the proper format")
    public void iMakeSureEmailAddressDisplayedInProperFormat() {
        support.validateEmailFormat();
    }
}
