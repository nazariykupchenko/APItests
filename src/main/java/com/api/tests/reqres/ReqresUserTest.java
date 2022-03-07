package com.api.tests.reqres;

import static com.api.utils.Properties.LIST_USERS_SCHEMA;
import static com.api.utils.Properties.SINGLE_USER_SCHEMA;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

import com.api.endpoints.reqres.ReqresUserEndpoint;
import com.api.models.reqres.CreateUserRequest;
import com.api.models.reqres.UpdateUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Slf4j
public class ReqresUserTest {

  private static final int SINGLE_USER_ID = 1;
  private static final int LIST_USERS_ID = 2;
  private final ReqresUserEndpoint reqresUserEndpoint = new ReqresUserEndpoint();

  @DataProvider(name = "data-provider")
  public Object[][] userDataProvider() {
    return new Object[][]{
        new Object[]{2, "Weaver"},
        new Object[]{7, "Lawson"}
    };
  }

  @Test
  public void userSchemaValidation() {
    reqresUserEndpoint
        .getSingleUser(1)
        .assertThat().body(matchesJsonSchemaInClasspath(SINGLE_USER_SCHEMA).using(
            settings().with().checkedValidation(false)));
    log.info("single user schema validation");
    reqresUserEndpoint
        .getListUsers(2)
        .assertThat().body(matchesJsonSchemaInClasspath(LIST_USERS_SCHEMA).using(
            settings().with().checkedValidation(false)));
    log.info("list users schema validation");
  }

  @Test(dataProvider = "data-provider")
  public void userLastNameTest(int id, String expectedLastName) {
    String actualLastName = reqresUserEndpoint
        .getSingleUser(id)
        .extract()
        .response()
        .jsonPath()
        .get("data.last_name");
    Assert.assertEquals(expectedLastName, actualLastName);
    log.info("test for user id {} , and last name {} finished", id, expectedLastName);
  }

  @Test
  public void createUserTest() {
    reqresUserEndpoint
        .createSingleUser(new CreateUserRequest("a", "b"));
    log.info("user created");
  }

  @Test
  public void updateUserTest() {
    reqresUserEndpoint
        .updateSingleUser(7, new UpdateUserRequest("q", "d"));
    log.info("user updated");
  }

  @AfterClass
  public void deleteUserTest() {
    reqresUserEndpoint
        .deleteSingleUser(7);
    log.info("user deleted");
  }
}
