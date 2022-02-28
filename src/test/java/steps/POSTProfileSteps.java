package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class POSTProfileSteps {
  private static ResponseOptions<Response> response;

  @Given("^I perform POST operation for \"([^\"]*)\"$")
  public void iPerformPOSTOperationFor(String url) throws Throwable {
    BDDSyledMethod.PerformPOSTWithBodyParameter();
  }

  @Given("^I Perform POST operation for \"([^\"]*)\" with body$")
  public void iPerformPOSTOperationForWithBody(String url, DataTable table) throws Throwable {
    var data = table.raw();

    // Set body
    HashMap<String, String> body = new HashMap<>();
    body.put("name", data.get(1).get(0));

    // Path params
    HashMap<String, String> pathParams = new HashMap<>();
    pathParams.put("profileNo", data.get(1).get(1));

    // Perform post operation
    response = RestAssuredExtension.PostOpsWithBodyAndPathParams(url, pathParams, body);
  }

  @Then("^I should see the body has name as \"([^\"]*)\"$")
  public void iShouldSeeTheBodyHasNameAs(String name) throws Throwable {
    assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
  }

  @Given("^I ensure to Perform POST operation for \"([^\"]*)\" with body as$")
  public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table)
      throws Throwable {
    var data = table.raw();
    Map<String, String> body = new HashMap<>();
    body.put("id", data.get(1).get(0));
    body.put("title", data.get(1).get(1));
    body.put("author", data.get(1).get(2));

    // Perform post operation
    RestAssuredExtension.PostOpsWithBody(url, body);
  }

  @And("^I Perform DELETE operation for \"([^\"]*)\"$")
  public void iPerformDELETEOperationFor(String url, DataTable table) throws Throwable {
    var data = table.raw();
    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("postid", data.get(1).get(0));

    // Perform Delete operation
    RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
  }

  @Then("^I should not see the body with title as \"([^\"]*)\"$")
  public void iShouldNotSeeTheBodyWithTitleAs(String title) throws Throwable {
    assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
  }

  @And("^I perform GET operation with path parameter for \"([^\"]*)\"$")
  public void iPerformGETOperationWithPathParameterFor(String url, DataTable table)
      throws Throwable {
    var data = table.raw();
    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("postid", data.get(1).get(0));
    response = RestAssuredExtension.GetWithPathParams(url, pathParams);
  }
}
