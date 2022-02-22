package com.api.endpoints.reqres;

import static com.api.utils.Properties.REQRES_BASE_URI;

import com.api.endpoints.Api;
import com.api.utils.Properties;
import io.restassured.response.ValidatableResponse;

public class ReqresResourcesEndpoint extends Api {

  public ValidatableResponse getSingleResource(int id) {
    return requestSpecification(REQRES_BASE_URI)
        .get(Properties.REQRES_RESOURCES_END_POINT + id)
        .then()
        .statusCode(200);
  }

  public ValidatableResponse getListResource() {
    return requestSpecification(REQRES_BASE_URI)
        .get(Properties.REQRES_RESOURCES_END_POINT)
        .then()
        .statusCode(200);
  }
}
