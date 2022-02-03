import io.restassured.RestAssured;
import org.testng.annotations.Test;
public class TestClass {
  @Test
  public void swapiFirstTest(){
    RestAssured
        .when().get("https://swapi.dev/api/people/1/")
        .then().assertThat().statusCode(200);

  }


}
