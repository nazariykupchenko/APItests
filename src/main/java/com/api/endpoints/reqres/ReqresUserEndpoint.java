package com.api.endpoints.reqres;

import static com.api.utils.Properties.REQRES_BASE_URI;
import static com.api.utils.Properties.REQRES_USERS_END_POINT;

import com.api.endpoints.Api;
import com.api.models.reqres.CreateUserRequest;
import com.api.models.reqres.UpdateUserRequest;
import io.restassured.response.ValidatableResponse;

public class ReqresUserEndpoint extends Api {

  public ValidatableResponse createSingleUser(CreateUserRequest body) {
    return requestSpecification(REQRES_BASE_URI)
        .body(body)
        .post(REQRES_USERS_END_POINT)
        .then()
        .statusCode(201);
  }

  public ValidatableResponse updateSingleUser(int id, UpdateUserRequest body) {
    return requestSpecification(REQRES_BASE_URI)
        .body(body)
        .put(REQRES_USERS_END_POINT + id)
        .then()
        .statusCode(200);
  }

  public ValidatableResponse getSingleUser(int id) {
    return requestSpecification(REQRES_BASE_URI)
        .get(REQRES_USERS_END_POINT + id)
        .then()
        .statusCode(200);
  }

  public ValidatableResponse getListUsers(int pageNum) {
    return requestSpecification(REQRES_BASE_URI)
        .queryParam("page", pageNum)
        .get(REQRES_USERS_END_POINT)
        .then()
        .statusCode(200);
  }

  public ValidatableResponse deleteSingleUser(int id) {
    return requestSpecification(REQRES_BASE_URI)
        .delete(REQRES_USERS_END_POINT + id)
        .then()
        .statusCode(204);
  }
}
