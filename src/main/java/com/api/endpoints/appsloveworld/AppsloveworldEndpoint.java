package com.api.endpoints.appsloveworld;

import static com.api.utils.Properties.APPSLOVEWORLD_BASE_URI;
import static com.api.utils.Properties.APPSLOVEWORLD_LOGIN;
import static com.api.utils.Properties.APPSLOVEWORLD_REGISTRATION;
import static com.api.utils.Properties.APPSLOVEWORLD_USERS_END_POINT;

import com.api.endpoints.Api;
import com.api.models.appsloveworld.LoginUserRequest;
import com.api.models.appsloveworld.RegisterUserRequest;
import com.api.utils.FileManager;
import io.restassured.response.ValidatableResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppsloveworldEndpoint extends Api {

  public ValidatableResponse registerUser(RegisterUserRequest body) {
    return requestSpecification(APPSLOVEWORLD_BASE_URI)
        .body(body)
        .post(APPSLOVEWORLD_REGISTRATION)
        .then();
  }

  public ValidatableResponse loginUser(String body) {
    return requestSpecification(APPSLOVEWORLD_BASE_URI)
        .body(body)
        .post(APPSLOVEWORLD_LOGIN)
        .then()
        .statusCode(200);
  }

  public ValidatableResponse loginUser(LoginUserRequest body) {
    return requestSpecification(APPSLOVEWORLD_BASE_URI)
        .body(body)
        .post(APPSLOVEWORLD_LOGIN)
        .then()
        .statusCode(200);
  }

  public ValidatableResponse authoriseWithToken(String token, int pageNum){
    return requestSpecification(APPSLOVEWORLD_BASE_URI)
        .header("Authorization", "Bearer " + token)
        .queryParam("page", pageNum)
        .get(APPSLOVEWORLD_USERS_END_POINT)
        .then()
        .statusCode(200);

  }
}