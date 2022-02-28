package steps;

import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class BDDSyledMethod {
  public static void SimpleGETPost(String postNumber) {
    when()
        .get(String.format("http://localhost:3000/posts/%s", postNumber))
        .then()
        .statusCode(200)
        .body("author", is("typicode"));
  }

  public static void PerformContainsCollection() {
    given()
        .contentType(ContentType.JSON)
        .when()
        .get("http://localhost:3000/posts/")
        .then()
        .body("author", containsInAnyOrder("typicode"))
        .statusCode(200);
  }

  public static void PerformPathParameter() {
    given()
        .contentType(ContentType.JSON)
        .with()
        .pathParams("post", 1)
        .when()
        .get("http://localhost:3000/posts/{post}")
        .then()
        .statusCode(200)
        .body("author", is("typicode"));
  }

  public static void PerformPOSTWithBodyParameter() {
    HashMap<String, String> postContent = new HashMap<>();
    postContent.put("id", "9");
    postContent.put("title", "Robotium course");
    postContent.put("author", "ExecuteAutomation");
    given()
        .contentType(ContentType.JSON)
        .with()
        .body(postContent)
        .when()
        .post("http://localhost:3000/posts")
        .then()
        .body("author", is("ExecuteAutomation"));
  }
}
