package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import middleware.Controller;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import requests.BASE_Request;

import java.util.List;
import java.util.stream.IntStream;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**************************
 *  (C) L Somni            *
 ***************************/

public class StepDefs {
    TestContext testContext;
    Response response;
    Controller controller;

    BASE_Request BASE_request = new BASE_Request();

    public StepDefs(TestContext context) {
        testContext = context;
        response = testContext.getResponse();
        controller = testContext.getController();
    }

    @Given("I use {string} API end point")
    public void iUseAPIEndPoint(final String sEndPoint) {
        BASE_request.chooseEndPoint(sEndPoint);
        testContext.setMock(false);
    }

    @When("I POST a request using {string}")
    public void makeAPostRequest(final String postCode) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("address", postCode);
        response = BASE_request.postRequest(requestParams,"/");
    }


    @Then("I get success response {string} code")
    public void iGetSuccessResponseCode(final String expectedStatusCode) {
        Assert.assertThat(Integer.toString(response.statusCode()), is(equalTo(expectedStatusCode)));
    }

    @And("response contains correct structure for the user end point response")
    public void responseContainsStructure() {
        response.then().body(matchesJsonSchemaInClasspath("met_response_schema.json"));
    }

    @And("I get error message as {string}")
    public void iGetErrorMessageAs(final String expectedError) {
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Assert.assertTrue(bodyAsString.toLowerCase().contains(expectedError.toLowerCase()));
    }
}
