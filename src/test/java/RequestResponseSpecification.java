import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestResponseSpecification {
  public RequestSpecification requestSpecification(){
    RestAssured.baseURI = "https://swapi.dev/api/people/1/";
    RequestSpecification requestSpecification = RestAssured
        .given();
    return requestSpecification;
  }

}
