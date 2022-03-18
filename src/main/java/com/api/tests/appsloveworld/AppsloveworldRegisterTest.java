package com.api.tests.appsloveworld;

import com.api.endpoints.appsloveworld.AppsloveworldEndpoint;
import com.api.models.appsloveworld.RegisterUserRequest;
import com.api.utils.FileManager;
import com.api.utils.JsonParser;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class AppsloveworldRegisterTest {

  private static final int PASSWORD = 123456;
  private static final String EMAIL = "Developer5@gmail.com";
  private final AppsloveworldEndpoint appsloveworldEndpoint = new AppsloveworldEndpoint();

  public String getToken() throws IOException {
    log.info("Get appsloveworld token");
    return appsloveworldEndpoint.loginUser(
            FileManager.getJsonString("src/main/resources/appsloveworld/login-request.json"))
        .extract()
        .response()
        .jsonPath()
        .get("data.Token");
  }

  @Test
  public void userRegisterTest() {
    String name = RandomStringUtils.random(5, true, false);
    String email = name + "@gmail.com";
    int password = ThreadLocalRandom.current().nextInt(100001, 999999);
    RegisterUserRequest registerUserRequest = new RegisterUserRequest(name, email, password);
    int responseCode = appsloveworldEndpoint
        .registerUser(registerUserRequest)
        .extract()
        .response()
        .jsonPath()
        .get("code");
    Assert.assertEquals(responseCode, 0);
  }

  @Test
  public void getUsersPage() throws IOException {
//    for (int i = 1; i < 10; i++) {
//      do {appsloveworldEndpoint
//          .authoriseWithToken(getToken(), i);
//      }
//      while ()
//      ;
//
//    }
    Map<String, String> actualMap =
        appsloveworldEndpoint
            .authoriseWithToken(getToken(), 1)
            .extract()
            .response()
            .jsonPath()
            .getObject("data[0]", JsonParser.class)
            .getMap();
    System.out.println(actualMap.toString());
    for (Map.Entry<String, String> item : actualMap.entrySet()) {
      System.out.println(item.getKey());
      System.out.println(item.getValue());
    }

//    System.out.println(
//    appsloveworldEndpoint
//        .authoriseWithToken(getToken(), 1)
//        .extract()
//        .response()
//        .jsonPath()
//        .getObject("data[0]", JsonParser.class)
//        .toString()
//    );
  }
}
