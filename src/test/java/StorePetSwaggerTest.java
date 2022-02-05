import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class StorePetSwaggerTest {
  @Before
  public void setUp() {
    baseURI = "https://petstore.swagger.io/v2";
  }

  @Test
  public void test01ReturnPetInventoriesByStatus() {
    given().when().get("/store/inventory").then().assertThat().statusCode(200);
  }
}
