package com.api.endpoints.reqres;

import static com.api.utils.Properties.REQRES_BASE_URI;
import static com.api.utils.Properties.REQRES_USERS_END_POINT;

import com.api.endpoints.Api;
import com.api.models.reqres.CreateUserResponse;
import com.api.models.reqres.UpdateUserResponse;
import io.restassured.response.ValidatableResponse;

public class ReqresUserEndpoint extends Api {

  public ValidatableResponse getSingleUser(int id) {
    return requestSpecification(REQRES_BASE_URI)
        .get(REQRES_USERS_END_POINT + id)
        .then()
        .statusCode(200);
  }

  public ValidatableResponse createSingleUser(CreateUserResponse body) {
    return requestSpecification(REQRES_BASE_URI)
        .post(REQRES_USERS_END_POINT + body)
        .then()
        .statusCode(201);
  }

  public ValidatableResponse updateSingleUser(UpdateUserResponse body) {
    return requestSpecification((REQRES_BASE_URI))
        .put(REQRES_USERS_END_POINT + body)
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
