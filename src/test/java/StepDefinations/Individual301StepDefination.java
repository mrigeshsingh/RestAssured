package StepDefinations;

import PayLoadPojo.Indv301Payload.SetValue.Indv301PayLoadSetValue;
import ResponsePojo.Individual301.Indv301ResponseMetricsDTO;
import io.cucumber.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import io.restassured.specification.RequestSpecification;
import utils.ReuseableMethods;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;


@RunWith(Cucumber.class)
public class Individual301StepDefination extends ReuseableMethods {
    RequestSpecification request;
    Indv301ResponseMetricsDTO indv301ResponseMetricsDTO;
    Indv301PayLoadSetValue indv301Payload = new Indv301PayLoadSetValue();

    @Given("^Get members Payload$")
    public void get_members_payload() throws FileNotFoundException {
        request = given().
                spec(getRequest()).
                body(indv301Payload.setValue("FULL_CYCLE","INCURRED_DATE","50","2"));
    }

    @When("^user calls \"([^\"]*)\" with POST http request$")
    public void user_calls_something_with_post_http_request(String strArg1) throws Throwable {
        indv301ResponseMetricsDTO = request.
                when().
                post("/members").
                then().spec(getResponse()).
                extract().response().as(Indv301ResponseMetricsDTO.class);
    }

    @Then("^the API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() throws Throwable {

    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String strArg1, String strArg2) throws Throwable {

    }

}