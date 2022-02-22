package com.api.endpoints.reqres;

import static com.api.utils.Properties.REQRES_BASE_URI;
import static com.api.utils.Properties.REQRES_USERS_END_POINT;

import com.api.endpoints.Api;
import io.restassured.response.ValidatableResponse;

public class ReqresUserEndpoint extends Api {

  public ValidatableResponse getSingleUser(int id) {
    return requestSpecification(REQRES_BASE_URI)
        .get(REQRES_USERS_END_POINT + id)
        .then()
        .statusCode(200);
  }
}
