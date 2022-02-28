package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class GetPostsSteps {

  private static ResponseOptions<Response> response;

  @Given("^I perform GET operation for \"([^\"]*)\"$")
  public void iPerformGETOperationFor(String url) throws Throwable {
    response = RestAssuredExtension.GetOps(url);
  }

  @Then("^I should see the author name as \"([^\"]*)\"$")
  public void iShouldSeeTheAuthorNameAs(String authorName) {
    assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
  }

  @Then("^I should see the author names$")
  public void iShouldSeeTheAuthorNames() {
    BDDSyledMethod.PerformContainsCollection();
  }

  @Then("^I should see verify GET parameter$")
  public void iShouldSeeVerifyGETParameter() {
    BDDSyledMethod.PerformPathParameter();
  }
}
